/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */
package game.data;

/*
 * This is an sample data file to which you may add the data defining
 * game objects including rooms and treasures.
 * You must be sure to create and initialize add these objects in the correct order.
 * For example, all Rooms must be created before they are initialzed (since each
 * Room object has references - exits - to other Room objects.
 */
import gameobjects.Actor;
import gameobjects.ContainerThing;
import gameobjects.GameThing;
import gameobjects.GenericThing;
import gameobjects.LockableThing;
import gameobjects.Room;
import gameobjects.Thing;
import globals.Dir;
import globals.Mass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GameData implements java.io.Serializable {

    // NOTE: 
    // map: 
    // This is not needed for the functioning of this game
    // since the player (an Actor object) can move from Room to Room
    // autonomously. However, a sequential list of all Rooms is useful
    // for debugging. 
    // 
    // things: 
    // The HashMap of things lets you find a thing (by its key) 
    // when you need to verify its state (open, closed, etc.) Again this
    // is not needed for the functioning of the game but it's useful
    // when debugging.
    public static ArrayList<Room> map; // the map - an ArrayList of Rooms    
    public static HashMap<String, Thing> things; // treasures
    public static Actor player;  // player - provides 'first person perspective'  
    private static String introtext = ""; // intro description

    public static void initGame() {

        // To construct a new Game, you should create and initialize objects 
        // in the order show. That's because some objects require other
        // objects - for example, all Rooms must be created before they
        // are initialized because Rooms refernce other Rooms for their 'exits'
        // --- construct a new adventure ---
        
        // STEP 1) --- Create rooms ---
        Room exampleRoom1 = new Room("exampleRoom1");
        Room exampleRoom2 = new Room("exampleRoom2");

        // STEP 2) --- Create Containers  ---
        //   You may add ContainerThing and LockableThing objects here        
        ContainerThing exampleContainer = new ContainerThing("exampleContainer", "an example container", Mass.SMALL);
        // optionally set its attributes
        exampleContainer.setOpenable(true);
        exampleContainer.setOpen(false);
        exampleContainer.addAdjectives(new String[]{"small", "example"});

        //   cupboard (locked)
        LockableThing cupboard = new LockableThing("cupboard", "cupboard on the wall", Mass.MEDIUM, false, false, true, false, true);
        cupboard.setShow(false);

        // STEP 3) --- Create Game Things (and Generic Things) --- 
        GameThing exampleGameThing = new GameThing("exampleGameThing", "lovely thing", Mass.BIG, false, false);
        // optionally set its attributes
        exampleGameThing.addAdjectives(new String[]{"lovely", "big", "shiny"});
        exampleGameThing.setLongDescription("lovely big, shiny thing");
        exampleGameThing.setShow(false);

        // GenericThings (scenery objects - not intended to be 'used' or taken)
        GenericThing lights = new GenericThing("lights", "flashing lights set into the walls", true);
       
        // STEP 4) --- Add Things to Containers (that is, put them "into" Containers)
        exampleContainer.addThing(exampleGameThing);

        // STEP 5) --- Add objects to Rooms                       
        exampleRoom1.addThing(exampleContainer);

        // STEP 6) Set any 'special' attributes
        cupboard.canBeUnlockedWith(exampleGameThing);

        // STEP 7) Optional but recommended - add all game objects to things
        // --- add all things to HashMap (for debugging)
        things = new HashMap<>();
        things.put("exampleGameThing", exampleGameThing);
        things.put("exampleContainer", exampleContainer);

        // STEP 8) Initialize rooms (including adding others room objects as 'exits'
        // and adding the pre-created lists (which may contain objects or may be empty)
        //           N,        S,           W,         E,       [Up],      [Down])
        exampleRoom1.init("a small but neat room.",
                Dir.NOEXIT, Dir.NOEXIT, Dir.NOEXIT, exampleRoom2);
        exampleRoom2.init("a big untidy room",
                Dir.NOEXIT, Dir.NOEXIT, exampleRoom1, Dir.NOEXIT);

        // STEP 9) Optional but recommended - add Rooms to map
        // create list of rooms (for debugging)
        map = new ArrayList<>();
        map.add(exampleRoom1);
        map.add(exampleRoom2);

        // STEP 10) create player and set location
        player = new Actor("player", "loveable game-player", exampleRoom1);

        // STEP 11) call method to define introductory text to show when game starts
        defineIntroText();
    }

    // Intro - add any text to be shown when game starts
    private static void defineIntroText() {
        introtext = "You are in a small room that smells of jasmine"
                + "What do you want to do?\n"
                + "(Enter q to quit)";
    }

    public static String introText() {
        return introtext;
    }
}
