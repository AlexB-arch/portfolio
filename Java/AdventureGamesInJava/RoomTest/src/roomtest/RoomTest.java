/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book 
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *    http://www.bitwisebooks.com
 * 
 */
package roomtest;

import gameobjects.Room;
import gameobjects.SimpleRoom;

/**
 *
 * @author Huw
 */
public class RoomTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleRoom sr;
        Room room0;
        Room room1;
        Room room2;
        Room room3;

        sr = new SimpleRoom();
        sr.name = "Troll Room";
        sr.description = "a dank room that smells of troll";
        sr.n = -1;
        sr.s = 2;
        sr.w = -1;
        sr.e = 1;

        System.out.println("sr.name=" + sr.name + " sr.s=" + sr.s);
        sr.name = "New name";
        sr.s = 100;
        System.out.println("NOW: sr.name=" + sr.name + " sr.s=" + sr.s);

        room0 = new Room("Troll Room", "a dank room that smells of troll", -1, 2, -1, 1);
        room1 = new Room("Forest", "a leafy woodland", -1, -1, 0, -1);
        room2 = new Room("Cave", "a dark cave", 0, -1, -1, 3);
        room3 = new Room("Dungeon", "a nasty basement in the castle", -1, -1, 2, -1);
        
        System.out.println("room0.getName()=" + room0.getName() + " room0.getS()=" + room0.getS());
        System.out.println("room1.getName()=" + room1.getName() + " room1.getS()=" + room1.getS());
        System.out.println("room2.getName()=" + room2.getName() + " room2.getS()=" + room2.getS());
        System.out.println("room3.getName()=" + room3.getName() + " room3.getS()=" + room3.getS());
        
       // room0.name = "New name";  // name is private - this won't compile
       room0.setS(100);
       System.out.println("NOW: room0.getName()=" + room0.getName() + " room0.getS()=" + room0.getS()); 
       room0.setS(99);
       System.out.println("2nd attempt: room0.getName()=" + room0.getName() + " room0.getS()=" + room0.getS()); 

    }

}
