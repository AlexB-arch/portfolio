/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */
package gameobjects;

/*
 * ContainerThing is a game object that may contain other things.
 * This distinguishes it from ordinary Thing objects (that can't contain things)
 * and also from other ThingHolder objects (such as Room and Actor) which can
 * contain things but are not 'game objects'.
 *
 */
public class ContainerThing extends ThingHolder implements java.io.Serializable {   
    
    private boolean openable;
    private boolean isopen;
    private int container_volume;

    // By default ContainerThings are open but not openable -
    // e.g. bowl, sack, basin
    public ContainerThing(String aName, String aDescription, int aMass, ThingList tl,
            ThingHolder aContainer) {
        super(aName, aDescription, aMass, tl, aContainer);
        openable = false;
        isopen = true;     
        container_volume = getMass() * 2; // set default volume to twice mass
    }

    // alternative constructor sets isopen and openable (e.g. something with lid)
    // e.g. chest, bottle, box
    public ContainerThing(String aName, String aDescription, int aMass,
            boolean canTake, boolean canMove, boolean canOpen, boolean isOpen,
            ThingList tl, ThingHolder aContainer) {
        super(aName, aDescription, aMass, canTake, canMove, tl, aContainer);
        openable = canOpen;
        isopen = isOpen;
        container_volume = getMass() * 2; // set default volume to twice mass
    }

    public boolean isOpenable() {
        return openable;
    }

    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    public boolean isOpen() {
        return isopen;
    }

    // --- actions on a Container
    @Override
    public String open() {
        String s;

        if (!openable) {
            s = "Can't open " + getName();
        } else {
            if (isopen) {
                s = "The " + getName() + " is already open.";
            } else {
                isopen = true;
                s = "You open the " + getName();
            }
        }
        return s;
    }

    @Override
    public String close() {
        String s;

        if (!openable) {
            s = "Can't close " + getName();
        } else {
            if (isopen) {
                isopen = false;
                s = "You close the " + getName();
            } else {
                s = "The " + getName() + " is already closed.";
            }
        }
        return s;
    }

    @Override
    public String describe() {
        String s;
        
        s = super.describe();
        if (openable) {
            if (isopen) {
                s += " (open)";
            } else {
                s += " (closed)";
            }
        }
        if (isopen) {
            if (getThings().size() > 0) {
                s += "\nThere is something in it.";
            }
        }
        return s;
    }

    // return mass contents of Container
    public int contentsMass(){
        ThingList tl;
        int countmass;
                
        tl = flatten();
        countmass = 0;
        for (Thing t : tl ){
            countmass += t.getMass();
        }
        return  countmass;
    }
    
    // return mass of Container and all it contains
    @Override
    public int totalMass(){
        return this.getMass() + contentsMass();
    }
    
    public int volume() { 
        return container_volume;
    }
    
    // in case you want to change from default value set in constructor
    public void setVolume(int aVolume) { 
        container_volume = aVolume;
    }
}
