/*
 * Sample Java file by Huw Collingbourne
 * 
 * This code (and other sample code) accompanies the book 
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */
package gameobjects;

public class ContainerThing extends ThingHolder implements java.io.Serializable {

    private boolean openable;
    private boolean isopen;

    public ContainerThing(String aName, String aDescription, ThingList tl) {
        super(aName, aDescription, tl);
        openable = false;
        isopen = true;
    }

    public ContainerThing(String aName, String aDescription,
            boolean canTake, boolean canMove, boolean canOpen, boolean openOrShut,
            ThingList tl) {
        super(aName, aDescription, canTake, canMove, tl);
        openable = canOpen;
        isopen = openOrShut;
    }

    public boolean isOpenable() {
        return openable;
    }

    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    public void open() {
        this.isopen = true;
    }

    public void close() {
        this.isopen = false;
    }

    public String describe() {
        String desc;
        String thingsdesc;

        desc = "This is " + getDescription();
        thingsdesc = getThings().describeThings();
        if (!thingsdesc.isEmpty()) {
            desc += "\nIn the " + getName() + " you can see:\n" + thingsdesc;
        }
        return desc;
    }

}
