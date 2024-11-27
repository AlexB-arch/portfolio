/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */

package gameobjects;

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
}
