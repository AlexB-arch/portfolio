/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package gameobjects;

import globals.Dir;

public class Room extends ThingHolder implements java.io.Serializable {

    private int n, s, w, e, up, down;

    public Room(String aName, String aDescription, int aN, int aS, int aW, int aE,
            ThingList tl) {
        super(aName, aDescription, tl); // init superclass
        this.n = aN;
        this.s = aS;
        this.w = aW;
        this.e = aE;
        this.up = Dir.NOEXIT;
        this.down = Dir.NOEXIT;
    }

    public Room(String aName, String aDescription, int aN, int aS, int aW, int aE,
            int anUp, int aDown,
            ThingList tl) {
        super(aName, aDescription, tl); // init superclass
        this.n = aN;
        this.s = aS;
        this.w = aW;
        this.e = aE;
        this.up = anUp;
        this.down = aDown;
    }

    // --- accessor methods ---
    // n
    public int getN() {
        return n;
    }

    public void setN(int aN) {
        this.n = aN;
    }

    // s
    public int getS() {
        return s;
    }

    public void setS(int aS) {
        this.s = aS;
    }

    // e
    public int getE() {
        return e;
    }

    public void setE(int aE) {
        this.e = aE;
    }

    // w
    public int getW() {
        return w;
    }

    void setW(int aW) {
        this.w = aW;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public String describe() {
        String roomdesc;
        String thingsdesc;

        roomdesc = String.format("%s. %s.", getName(), getDescription());        
        thingsdesc = describeThings();
        if (!thingsdesc.isEmpty()) {
            roomdesc += "\nThings here:\n" + thingsdesc;
        }
        return roomdesc;
    }
}
