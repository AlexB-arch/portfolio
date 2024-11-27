/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package gameobjects;

import globals.Mass;

public class Thing implements java.io.Serializable {

    // Basic Thing type that defines all objects in the Adventure
    // This is not intended to be used directly.
    // One of its descendents should be used for actual Game Objects
    private String name;
    private String description;
    private boolean takable;
    private boolean movable;
    // size:
    // so I know if this is a big thing or not
    // e.g.
    // coin, pencil etc = 1
    // chair etc = 15
    // tree = 100
    private int mass;
    private ThingHolder container;

    public Thing(String aName, String aDescription, int aMass, ThingHolder aContainer) {
        // constructor
        this.name = aName;
        this.description = aDescription;
        this.mass = aMass;
        this.takable = true;
        this.movable = true;
        this.container = aContainer;
        testMass();
    }

    public Thing(String aName, String aDescription,
            int aMass,
            boolean canTake, boolean canMove,
            ThingHolder aContainer) {
        // constructor
        this.name = aName;
        this.description = aDescription;
        this.mass = aMass;
        this.takable = canTake;
        this.movable = canMove;
        this.container = aContainer;
        testMass();
    }

    private void testMass() {
        if ((mass < Mass.UNKNOWN) || (mass > Mass.HUGE)) {
            throw new IncorrectMassException("Mass value " + mass + " is invalid!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }

    public int getMass() {
        return mass;
    }

    public int totalMass() {
        return mass;
    }

    public boolean isTakable() {
        return takable;
    }

    public void setTakable(boolean takable) {
        this.takable = takable;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public ThingHolder getContainer() {
        return container;
    }

    public void setContainer(ThingHolder container) {
        this.container = container;
    }

    public String open() {
        return "Cannot open " + name + " because it isn't a container.";
    }

    public String close() {
        return "Cannot close " + name + " because it isn't a container.";
    }

    public String describe() {
        return name + " " + description;
    }

    // is this Thing inside aContainer?
    private Boolean isInside(ContainerThing aContainer) {
        ThingHolder th;
        Boolean isInContainer = false;

        th = this.getContainer();
        while (th != null) {
            if (th == aContainer) {
                isInContainer = true;
            }
            th = th.getContainer();
        }
        return isInContainer;
    }

    public Boolean isIn(Thing t) {
        return (t instanceof ContainerThing) && (this.isInside((ContainerThing) t));
    }
}

class IncorrectMassException
        extends RuntimeException {

    public IncorrectMassException(String errorMessage) {
        super(errorMessage);
    }
}
