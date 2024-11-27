/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package gameobjects;

public class Thing implements java.io.Serializable {
// Basic Thing type that defines all objects in the Adventure

    private String name;
    private String description;
    private boolean takable;
    private boolean movable;

    
    public Thing(String aName, String aDescription) {
        // constructor
        this.name = aName;
        this.description = aDescription;
        this.takable = true;
        this.movable = true;
    }
    
    public Thing(String aName, String aDescription, boolean canTake, boolean canMove) {
        // constructor
        this.name = aName;
        this.description = aDescription;
        this.takable = canTake;
        this.movable = canMove;
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
    
    public String open() {
        return "Cannot open " + name + " because it isn't a container.";
    }
    
    public String close() {
        return "Cannot close " + name + " because it isn't a container.";
    }
    
    public String describe(){
        return name + " " + description;
    }
}
