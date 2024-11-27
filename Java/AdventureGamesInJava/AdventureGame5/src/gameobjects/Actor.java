/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package gameobjects;

import globals.ThingAndThingHolder;

public class Actor extends ThingHolder implements java.io.Serializable {

    private Room location; // the Room where the Person is at present

    public Actor(String aName, String aDescription, ThingList tl, Room aRoom) {
        super(aName, aDescription, tl); // init super class
        this.location = aRoom;
    }

    public void setLocation(Room aRoom) {
        this.location = aRoom;
    }

    public Room getLocation() {
        return this.location;
    }

    public String describeLocation() {
        return location.describe();
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
        ThingAndThingHolder t_and_th;
        
        t_and_th = isThingInInventory(obname);
        if (t_and_th == null) {
            t_and_th = isThingInRoom(obname);
        }
        return t_and_th;
    }

    public ThingAndThingHolder isThingInInventory(String obname) {
        return this.findThing(obname);
    }

    public ThingAndThingHolder isThingInRoom(String obname) {
        return location.findThing(obname);
    }

    public String closeOb(String obname) {
        ThingAndThingHolder t_and_th = null;
        Thing t = null;
        String s = "";
        
        if (obname.isEmpty()) {
            s = "You'll have to say what you want to close!";
        } else {
            t_and_th = isThingHere(obname);
            t = t_and_th.getThing();
            if (t == null) {
                s = "There is no " + obname + " here!";
            } else {
                s = t.close();
            }
        }
        return s;
    }

    public String openOb(String obname) {
        ThingAndThingHolder t_and_th = null;
        Thing t = null;
        String s = "";
        
        if (obname.isEmpty()) {
            s = "You'll have to say what you want to close!";
        } else {
            t_and_th = isThingHere(obname);
            t = t_and_th.getThing();
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
        ThingAndThingHolder t_and_th = isThingHere(obname);
        Thing t = null;
        ThingHolder th = null;

        if (t_and_th == null) {
            s = "Can't see " + obname + " here.";
        } else {
            t = t_and_th.getThing();
            th = t_and_th.getThingHolder();
            if (!(t instanceof ContainerThing)) {
                s = "You can't look inside the " + t.getName() + ".";
            } else {
                if (((ContainerThing) t).isOpen()) {
                    s = ((ContainerThing) t).describeThings();
                    if (s.isEmpty()) {
                        s = "There is nothing in the " + t.getName();
                    } else {
                        s = "The " + t.getName() + " contains:\n" + s;
                    }
                } else {
                    s += "The " + t.getName() + " isn't open.";
                }
            }
        }
        return s;
    }

    public String lookAt(String obname) {
        String s = "";
        ThingAndThingHolder t_and_th = isThingHere(obname);
        Thing t = null;
        ThingHolder th = null;

        if (t_and_th == null) {
            s = "Can't see " + obname + " here.";
        } else {
            t = t_and_th.getThing();
            th = t_and_th.getThingHolder();
            if (th instanceof ContainerThing) {
                s = "[The " + t.getName() + " is inside " + th.getName() + "]\n";
            }
            s += t.describe();
        }
        return s;
    }

    private ContainerThing toContainerThing(Thing t) {
        ContainerThing ct = null;

        if (t instanceof ContainerThing) {
            ct = (ContainerThing) t;
        }
        return ct;
    }

    public String putInto(String obname, String containername) {     
        String s = "";
        ThingAndThingHolder ob_and_thingholder;
        Thing ob = null;        
        ThingAndThingHolder container_and_thingholder;
        ContainerThing container = null;

        ob_and_thingholder = isThingInInventory(obname); // is it in player's inventory?        
        container_and_thingholder = isThingHere(containername); // is it in room or inventory?

        if (ob_and_thingholder == null) {
            s = "You haven't got the " + obname;
        } else if (container_and_thingholder == null) {
            s = "There is no " + containername + " here!";
        } else { // if Thing and Container are found
            ob = ob_and_thingholder.getThing();            
            container = toContainerThing(container_and_thingholder.getThing());
            if ((container == null)) {      // container is not a ContainerThing
                s = "You can't put the " + obname + " into the " + containername + "!";
            } else if (ob == container) {
                s = "You can't put the " + obname + " into itself!";
            } else if (container.containsThing(ob)) {
                s = "The " + obname + " is already in the " + containername;
            } else if (!(container).isOpen()) {
                s = "You can't put the " + obname + " into a closed " + containername + "!";
            } else {
                transferOb(ob, this.getThings(), container.getThings());
                s = "You put the " + obname + " into the " + containername + ".";
            }
        }
        return s;
    }

    public String take(String obname) {
        String s;
        ThingAndThingHolder t_and_th = isThingHere(obname);
        Thing t = null;
        ThingList tl = null;
        ThingHolder th = null;

        if (t_and_th == null) {
            s = "Can't see " + obname + " here.";
        } else {
            t = t_and_th.getThing();
            tl = t_and_th.getList();
            th = t_and_th.getThingHolder();
            if (tl == this.getThings()) {
                s = "You already have the " + obname;
            } else {
                if (t.isTakable()) {
                    transferOb(t, tl, this.getThings());
                    if (th instanceof ContainerThing) {
                        s = "You take the " + obname + " from the " + th.getName();
                    } else {
                        s = obname + " taken!";
                    }
                } else {
                    s = "You can't take the " + t.getName() + "!";
                }
            }
        }
        return s;
    }

    public String drop(String obname) {
        String s;
        ThingAndThingHolder t_and_th = this.findThing(obname);
        Thing t = null;
        ThingList tl = null;

        if (t_and_th == null) {
            s = "You don't appear to have the " + obname + ".";
        } else {
            t = t_and_th.getThing();
            tl = t_and_th.getList();
            transferOb(t, tl, this.location.getThings());
            s = obname + " dropped!";
        }
        return s;
    }
}
