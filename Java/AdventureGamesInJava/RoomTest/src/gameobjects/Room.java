/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book 
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *    http://www.bitwisebooks.com
 * 
 */
package gameobjects;

public class Room {

    private String name, description;
    private int n, s, w, e;

    public Room(String aName, String aDescription, int aN, int aS, int aW, int aE) {
        name = aName;
        description = aDescription;
        n = aN;
        s = aS;
        w = aW;
        e = aE;
    }

    // --- accessor methods ---
    // name
    // Noe set accessor so the room name cannot be changed
    public String getName() {
        return name;
    }

    // description
    public String getDescription() {
        return "This is " + description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    // n
    public int getN() {
        return n;
    }

    public void setN(int aN) {
        n = aN;
    }

    // s
    public int getS() {
        return s;
    }

    public void setS(int aS) {
        // don't allow values of 100 or greater to be assigned
        if (aS < 100) {
            s = aS;
        } else {
            System.out.println("Error: Room index must be less than 100");
        }
    }

    // e
    public int getE() {
        return e;
    }

    public void setE(int aE) {
        e = aE;
    }

    // w
    public int getW() {
        return w;
    }

    void setW(int aW) {
        w = aW;
    }
}
