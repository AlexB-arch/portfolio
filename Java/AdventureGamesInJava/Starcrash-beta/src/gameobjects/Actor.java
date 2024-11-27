/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package gameobjects;

import globals.Debug;
import globals.Dir;
import globals.Mass;
import globals.ThingAndThingHolder;

public class Actor extends ThingHolder implements java.io.Serializable {

    final int MAXLOAD = Mass.MEDIUM + Mass.SMALL;

    private int load;

    public Actor(String aName, String aDescription, ThingList tl, Room aRoom) {
        super(aName, aDescription, Mass.UNKNOWN, tl, aRoom); // init super class      
        load = 0;
    }

    public void setLocation(Room aRoom) {
        setContainer(aRoom);
    }

    public Room getLocation() {
        return (Room) getContainer();
    }

    public String describeLocation() {
        return ((Room) getContainer()).describe();
    }

    public String inventory() {
        String s;
        s = describeThings();
        if (s.isEmpty()) {
            s = "nothing";
        }
        return "You have " + s;
    }

    // is the thing found in any list (including 'nested' lists
    // either in the player's inventory or in the current location?
    // If so, return ThingAndThingHolder initialized with Thing/ThingHolder
    public ThingAndThingHolder isThingHere(String obname) {
        ThingAndThingHolder t_th;

        t_th = isThingInInventory(obname);
        if (t_th == null) {
            t_th = isThingInRoom(obname);
        }
        return t_th;
    }

    public ThingAndThingHolder isThingInInventory(String obname) {
        return this.findThing(obname);
    }

    public ThingAndThingHolder isThingInRoom(String obname) {
        //  return location.findThing(obname);
        return ((Room) getContainer()).findThing(obname);
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public String closeOb(String obname) {
        ThingAndThingHolder t_th;
        Thing t;
        String s;

        if (obname.isEmpty()) {
            s = "You'll have to say what you want to close!";
        } else {
            t_th = isThingHere(obname);
            t = t_th.getThing();
            if (t == null) {
                s = "There is no " + obname + " here!";
            } else {
                s = t.close();
            }
        }
        return s;
    }

    public String openOb(String obname) {
        ThingAndThingHolder t_th;
        Thing t;
        String s;

        if (obname.isEmpty()) {
            s = "You'll have to say what you want to close!";
        } else {
            t_th = isThingHere(obname);
            t = t_th.getThing();
            if (t == null) {
                s = "There is no " + obname + " here!";
            } else {
                s = t.open();
            }
        }
        return s;
    }

    public String lookIn(String obname) {
        String s = "";
        ThingAndThingHolder t_th;
        Thing t;
        ContainerThing container;

        t_th = isThingHere(obname);
        if (t_th == null) {
            s = "Can't see " + obname + " here.";
        } else {
            t = t_th.getThing();
            container = toContainerThing(t);
            if (container == null) {
                s = "You can't look inside the " + t.getName() + ".";
            } else {
                if (container.isOpen()) {
                    s = container.describeThings();
                    if (s.isEmpty()) {
                        s = "There is nothing in the " + container.getName();
                    } else {
                        s = "The " + container.getName() + " contains:\n" + s;
                    }
                } else {
                    s += "The " + container.getName() + " isn't open.";
                }
            }
        }
        return s;
    }

    public String lookAt(String obname) {
        String s = "";
        ThingAndThingHolder t_th;
        Thing t;
        ThingHolder th;

        t_th = isThingHere(obname);
        if (t_th == null) {
            s = "Can't see " + obname + " here.";
        } else {
            t = t_th.getThing();
            th = t_th.getThingHolder();
            if (th instanceof ContainerThing) {
                s = "[The " + t.getName() + " is inside " + th.getName() + "]\n";
            }
            s += t.describe();
        }
        return s;
    }

    public String putInto(String obname, String containername) {
        String s;
        ThingAndThingHolder t_th;
        Thing t;
        ThingAndThingHolder cont_th;
        ContainerThing container;
        Boolean containerIsInRoom = false;

        t_th = isThingInInventory(obname); // is it in player's inventory?        
        cont_th = isThingHere(containername); // is it in room or inventory?

        if (cont_th.getThingHolder() instanceof Room) {
            containerIsInRoom = true;
        }

        if (t_th == null) {
            s = "You haven't got the " + obname;
        } else if (cont_th == null) {
            s = "There is no " + containername + " here!";
        } else { // if Thing and Container are found
            t = t_th.getThing();
            container = toContainerThing(cont_th.getThing());
            if ((container == null)) {      // container is not a ContainerThing
                s = "You can't put the " + obname + " into the " + containername + "!";
            } else if (t == container) {
                s = "You can't put the " + obname + " into itself!";
            } else if (container.containsThing(t)) {
                s = "The " + obname + " is already in the " + containername;
            } else if (!(container).isOpen()) {
                s = "You can't put the " + obname + " into a closed " + containername + "!";
            } else if (container.isIn(t)) {
                s = "You can't put the " + obname + " into the " + containername
                        + "\nbecause the " + containername + " is already in the " + obname + "!";
            } else if ((container.totalMass() + t.totalMass()) > container.volume()) {
                s = "The " + containername + " isn't big enough for the " + obname;
                if (container.numberOfThings() > 0) {
                    s += "\nMaybe you could take something out of it and try again?";
                }
            } else {
                transferOb(t, t_th.getThingHolder(), container);
                if (containerIsInRoom) { // if putting into container in Room
                    load -= t.getMass(); // decrease load  
                }
                s = "You put the " + obname + " into the " + containername + ".";
                // DEBUG: putInto()
                if (Debug.ON) {
                    s += "\nload=" + load + " t.getMass()= " + t.getMass() + " MAXLOAD=" + MAXLOAD;
                    s += "\ncontainer.volume()=" + container.volume();
                    s += "\ncontainer.totalMass()" + container.totalMass();
                }
            }
        }
        return s;
    }

    private String debugTakeDrop(Thing t, int totalMass, Boolean isContainer) {
        String s = "";

        s += "\nPlayer load=" + load + " MAXLOAD=" + MAXLOAD
                + ". Mass of " + t.getName() + "=" + t.getMass();
        if (isContainer) {
            s += " (This is a Container) total mass = " + totalMass;
        }
        return s;
    }

    private String doTake(Thing t, ThingHolder th) {
        String s;
        ContainerThing ct;
        int tmass;
       
        tmass = t.totalMass();

        if (t.isTakable()) {
            if ((load + tmass) > MAXLOAD) {
                s = "You are carrying too much. You need to drop\n"
                        + "something before taking the " + t.getName();
            } else {
                load += tmass;
                transferOb(t, th, this);
                if (th instanceof ContainerThing) {
                    s = "You take the " + t.getName() + " from the " + th.getName();
                } else {
                    s = t.getName() + " taken!";
                }
            }
        } else {
            s = "You can't take the " + t.getName() + "!";
        }
        //DEBUG: take
        if (Debug.ON) {
            ct = toContainerThing(t);
            s += debugTakeDrop(t, tmass, ct != null);
        }
        return s;
    }

    public String take(String obname) {
        String s;
        ThingAndThingHolder t_th;
        Thing t;
        ThingList tl;
        ThingHolder th;

        t_th = isThingHere(obname);
        if (t_th == null) {
            s = "Can't see " + obname + " here.";
        } else {
            t = t_th.getThing();
            tl = t_th.getList();
            th = t_th.getThingHolder();
            if (tl == this.getThings()) {
                s = "You already have the " + obname;
            } else {
                s = doTake(t, th);
            }
        }
        return s;
    }

    public String drop(String obname) {
        String s;
        ThingAndThingHolder t_th;
        Thing t;

        ContainerThing ct;
        int tmass;

        t_th = this.findThing(obname);
        if (t_th == null) {
            s = "You don't appear to have the " + obname + ".";
        } else {
            t = t_th.getThing();          
            tmass = t.totalMass();
            transferOb(t, t_th.getThingHolder(), this.getLocation());
            load -= tmass;
            s = obname + " dropped!";
            //DEBUG: drop
            if (Debug.ON) {
                ct = toContainerThing(t);
                s += debugTakeDrop(t, tmass, ct != null);
            }
        }
        return s;
    }

    public Boolean moveTo(Dir dir) {
        Room r;
        Room exit;
        Boolean moved = false;

        r = getLocation();
        switch (dir) {
            case NORTH:
                exit = r.getN();
                break;
            case SOUTH:
                exit = r.getS();
                break;
            case EAST:
                exit = r.getE();
                break;
            case WEST:
                exit = r.getW();
                break;
            case UP:
                exit = r.getUp();
                break;
            case DOWN:
                exit = r.getDown();
                break;
            default:
                exit = null; // noexit - stay in same room
                break;
        }
        if (exit != null) {
            setLocation(exit);
            moved = true;
        }
        return moved;
    }
}
