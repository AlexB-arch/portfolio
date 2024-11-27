/*
 * Sample Java file by Huw Collingbourne
 * 
 * This code (and other sample code) accompanies the book 
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */
package overriding;

import java.util.ArrayList;

class Thing {

    private String description;

    public Thing(String aDescription) {
        this.description = aDescription;
    }

    public String describe() {
        return description;
    }
}

class Treasure extends Thing {

    private int value;

    public Treasure(String aDescription, int aValue) {
        super(aDescription);
        this.value = aValue;
    }

    @Override
    public String describe() {
        return "The " + super.describe() + " is a treasure worth "
                + value + " groats.";
    }

}

public class Overriding {

    public static void main(String[] args) {
        Thing thing1, thing2;
        Treasure treasure1, treasure2;
        ArrayList<Thing> thinglist;

        thing1 = new Thing("Tree");
        thing2 = new Thing("Rock");
        treasure1 = new Treasure("Sword", 100);
        treasure2 = new Treasure("Ring", 500);
        thinglist = new ArrayList<>();
        thinglist.add(thing1);
        thinglist.add(thing2);
        thinglist.add(treasure1);
        thinglist.add(treasure2);
        for (Thing t : thinglist) {
            System.out.println(t.describe());
        }
    }

}
