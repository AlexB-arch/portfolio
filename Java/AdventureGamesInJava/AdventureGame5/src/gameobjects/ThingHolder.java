/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package gameobjects;

import globals.ThingAndThingHolder;

public class ThingHolder extends Thing implements java.io.Serializable {

    private ThingList things;
    private ThingAndThingHolder t_and_th = null;
    private String thingStr = "";

    public ThingHolder(String aName, String aDescription, ThingList tl) {
        super(aName, aDescription);
        things = tl;
    }

    public ThingHolder(String aName, String aDescription, boolean canTake,
            boolean canMove, ThingList tl) {
        super(aName, aDescription, canTake, canMove);
        things = tl;
    }

    /*
     * Thing is 'here' if it is visible (e.g. it's in a Room if it is an object
     * in that room or an object in an open container in that room).
     *
     * Recursively look for a Thing called obname in the list maintained by the
     * ThingHolder th. If found in that list any list 'branching off' it, the
     * object variable t_and_th is initialized with the Thing and the
     * ThingHolder which 'contains' it.
     */
    private void findThingInAnyList(ThingHolder th, String obname) {
        boolean found = false;

        for (Thing t : th.getThings()) {
            if (t.getName().equals(obname)) {
                t_and_th = new ThingAndThingHolder(t, th);
                found = true;
            }
            if (!found) {
                if ((t instanceof ContainerThing) && ((ContainerThing) t).isOpen()) {
                    findThingInAnyList(((ContainerThing) t), obname);
                }
            }
        }
    }

    private void doDescribeThings(ThingHolder th) {
        ThingList tlist = th.getThings();
        
        for (Thing t : tlist) {
            thingStr += t.getName() + "\n";
            if ((t instanceof ContainerThing) && ((ContainerThing) t).isOpen()) {
                if (((ContainerThing) t).getThings().size() > 0) {
                    thingStr += "The " + t.getName() + " contains: \n";
                    doDescribeThings(((ContainerThing) t));
                }
            }
        }
    }

    public String describeThings() {
        thingStr = "";
        doDescribeThings(this);
        return thingStr;
    }

    public boolean containsThing(Thing t) {
        return getThings().contains(t);
    }

    public ThingAndThingHolder findThing(String obname) {
        t_and_th = null;
        findThingInAnyList(this, obname);
        return t_and_th;
    }

    public ThingList getThings() {
        return things;
    }

    public void setThings(ThingList things) {
        this.things = things;
    }

    protected void transferOb(Thing t, ThingList fromlist, ThingList tolist) {
        fromlist.remove(t);
        tolist.add(t);
    }

}
