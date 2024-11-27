/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package gameobjects;


public class GameThing extends Thing implements java.io.Serializable{
    /*
    This is a very simple example of a subclass of the Thing class.    
    */

   

    public GameThing(String aName, String aDescription, int aMass, ThingHolder aContainer) {
        super(aName, aDescription, aMass, aContainer); // init superclass        
    }
       
    public GameThing(String aName, String aDescription,
            int aMass,
            boolean canTake, boolean canMove,
            ThingHolder aContainer) {
        super(aName, aDescription, aMass, canTake, canMove, aContainer);        
    }

}
