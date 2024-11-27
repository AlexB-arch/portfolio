/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package gameobjects;

public class ThingHolder extends Thing implements java.io.Serializable{

    private ThingList things = new ThingList( );
    
    public ThingHolder(String aName, String aDescription, ThingList tl) {
        super(aName, aDescription);
        things = tl;
    }
    
    public ThingHolder(String aName, String aDescription, boolean canTake,
            boolean canMove, ThingList tl) {
        super(aName, aDescription, canTake, canMove);
        things = tl;
    }
   
    public ThingList getThings() {
        return things;
    }
   
    public void setThings(ThingList things) {
        this.things = things;
    }
    
}
