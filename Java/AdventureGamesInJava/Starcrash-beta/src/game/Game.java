/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package game;

import java.util.*;     // required for ArrayList
import gameobjects.Actor;
import gameobjects.ContainerThing;
import gameobjects.Room;
import gameobjects.Thing;
import gameobjects.ThingList;
import gameobjects.GameThing;
import globals.Dir;
import globals.Mass;

public class Game implements java.io.Serializable {

    private ArrayList<Room> map; // the map - an ArrayList of Rooms    
    private Actor player;  // the player - provides 'first person perspective'  

    public Game() {
        Parser.initVocab();
        initGame();
    }
    

    private void initGame() {
        // NOTE: map is no longer needed for the functioning of this game
        // since the player (an Actor object) can move from Room to Room
        // autonomously. However, a sequential list of all Rooms is useful
        // for debuging, so map has been retained.
        this.map = new ArrayList<Room>();

        // --- construct a new adventure ---
        // 1) lists of Things in each room
        ThingList readyRoomList = new ThingList("readyRoomList");
        ThingList bridgeList = new ThingList("bridgeList");
        ThingList meetingRoomList = new ThingList("meetingRoomList");
        ThingList engineRoomList = new ThingList("engineRoomList");
        ThingList holoDeckList = new ThingList("holoDeckList");
        ThingList corridorList = new ThingList("corridorList");
        ThingList basementList = new ThingList("basementList");
        ThingList diningRoomList = new ThingList("diningRoomList");
        ThingList hydroponicsNorthList = new ThingList("hydroponicsNorthList");
        ThingList hydroponicsList = new ThingList("hydroponicsList");
        ThingList hydroponicsSouthList = new ThingList("hydroponicsSouthList");
        ThingList greenhouseList = new ThingList("greenhouseList");

        // 2) list for player's inventory
        ThingList playerlist = new ThingList("playerList");

        // 3) create rooms
        Room readyRoom = new Room();
        Room bridge = new Room();
        Room meetingRoom = new Room();
        Room engineRoom = new Room();
        Room holoDeck = new Room();
        Room corridor = new Room();
        Room basement = new Room();
        Room diningRoom = new Room();
        Room hydroponicsNorth = new Room();
        Room hydroponicsCentral = new Room();
        Room hydroponicsSouth = new Room();
        Room greenhouse = new Room();

        ThingList boxList = new ThingList("boxList");
        ContainerThing box = new ContainerThing("box", "a small cardboard box", Mass.SMALL, boxList, readyRoom);
        
        ThingList cupboardList = new ThingList("cupboardList");
        ContainerThing cupboard = new ContainerThing("cupboard", "a cupboard on the wall", Mass.MEDIUM, false, false, true, true, cupboardList, readyRoom);
        
        boxList.add(new GameThing("key", "silver key", Mass.TINY, box));
        boxList.add(new GameThing("ring", "gold ring", Mass.TINY, box));

        // 4) add objects to lists
        readyRoomList.add(new GameThing("desk", "It is a desk on which is computer", Mass.MEDIUM, false, false, readyRoom));
        readyRoomList.add(new GameThing("computer", "It is a small computer fixed to a desk", Mass.MEDIUM, false, false, readyRoom));
        readyRoomList.add(new GameThing("chair", "It is a plain, uncomfortable-looking operator's chair", Mass.MEDIUM, readyRoom));
        readyRoomList.add(box);
        readyRoomList.add(cupboard);

        bridgeList.add(new GameThing("sausage", "It is a plump pork sausage", Mass.SMALL, bridge));

        meetingRoomList.add(new GameThing("paper", "Someone has written a message on the scrap of paper using a blunt pencil. It says 'This space is intentionally left blank'", 1, meetingRoom));
        meetingRoomList.add(new GameThing("pencil", "This pencil is so blunt that it can no longer be used to write.", Mass.TINY, meetingRoom));

        engineRoomList.add(new GameThing("ring", "It is a ring of great power.", Mass.TINY, holoDeck));
        engineRoomList.add(new GameThing("wombat", "It's a cuddly little wombat. It is squeaking gently to itself.", Mass.SMALL, holoDeck));

        // 5) Initialize rooms (including adding others room objects as 'exits'
        // and adding the pre-created lists (which may contain objects or may be empty)
        //           N,        S,           W,         E,       [Up],      [Down])
        readyRoom.init("Ready Room", "A small but neat room.",
                Dir.NOEXIT, Dir.NOEXIT, Dir.NOEXIT, bridge,
                readyRoomList);
        bridge.init("Bridge", "The bridge of HMS Starcrash.",
                Dir.NOEXIT, Dir.NOEXIT, readyRoom, Dir.NOEXIT, Dir.NOEXIT, meetingRoom,
                bridgeList);
        meetingRoom.init("Meeting Room", "A typical very boring-looking meeting room.",
                Dir.NOEXIT, Dir.NOEXIT, Dir.NOEXIT, corridor, bridge, engineRoom,
                meetingRoomList);
        engineRoom.init("Engine Room", "A big, clanky, oily room full of strange, chugging machinery.",
                Dir.NOEXIT, Dir.NOEXIT, Dir.NOEXIT, basement, meetingRoom, Dir.NOEXIT,
                engineRoomList);
        corridor.init("Corridor", "A long corridor with doors to the left and right and a stairway leading down.",
                Dir.NOEXIT, Dir.NOEXIT, meetingRoom, diningRoom, Dir.NOEXIT, basement,
                corridorList);
        basement.init("Basement", "A dark room at the bottom of the ship.",
                Dir.NOEXIT, Dir.NOEXIT, engineRoom, hydroponicsNorth, corridor, Dir.NOEXIT,
                basementList);
        holoDeck.init("Holodeck", "A big, empty room.",
                Dir.NOEXIT, diningRoom, Dir.NOEXIT, Dir.NOEXIT,
                holoDeckList);
        diningRoom.init("Dining Room", "A room full of tables and chairs.",
                holoDeck, Dir.NOEXIT, corridor, Dir.NOEXIT,
                diningRoomList);
        hydroponicsNorth.init("Hydroponics", "A steamy hydroponics area with plants everywhere.",
                Dir.NOEXIT, hydroponicsCentral, basement, hydroponicsCentral,
                hydroponicsNorthList);
        hydroponicsCentral.init("Hydroponics", "A steamy hydroponics area with plants everywhere.",
                hydroponicsNorth, hydroponicsSouth, hydroponicsSouth, hydroponicsNorth,
                hydroponicsList);
        hydroponicsSouth.init("Hydroponics", "A steamy hydroponics area with plants everywhere.",
                hydroponicsCentral, greenhouse, hydroponicsCentral, Dir.NOEXIT,
                hydroponicsSouthList);
        greenhouse.init("Greenhouse", "A huge glass structure filled with plants.\nThe air is hot and steamy.\nYou hear the sound of birds.",
                hydroponicsSouth, Dir.NOEXIT, Dir.NOEXIT, Dir.NOEXIT,
                greenhouseList);

        // create list of rooms (for possible debugging)
        map.add(readyRoom);
        map.add(bridge);
        map.add(meetingRoom);
        map.add(engineRoom);
        map.add(holoDeck);
        map.add(corridor);
        map.add(basement);
        map.add(diningRoom);
        map.add(hydroponicsNorth);
        map.add(hydroponicsCentral);
        map.add(hydroponicsSouth);
        map.add(greenhouse);

        // create player and set location
        player = new Actor("player", "a loveable game-player", playerlist, bridge);
    }

    // access methods     
    public String putObInContainer(String obname, String containername) {
        return player.putInto(obname, containername);
    }

    public String openOb(String obname) {
        return player.openOb(obname);
    }

    public String closeOb(String obname) {
        return player.closeOb(obname);
    }

    String takeOb(String obname) {
        String retStr;

        retStr = player.take(obname);
        return retStr;
    }

    String dropOb(String obname) {
        String retStr;

        retStr = player.drop(obname);
        return retStr;
    }

    void movePlayerTo(Dir dir) {
        if (player.moveTo(dir)) {
            look();
        } else {
            showStr("No Exit!");
        }
    }

    void goN() {
        movePlayerTo(Dir.NORTH);
    }

    void goS() {
        movePlayerTo(Dir.SOUTH);
    }

    void goW() {
        movePlayerTo(Dir.WEST);
    }

    void goE() {
        movePlayerTo(Dir.EAST);
    }

    void goUp() {
        movePlayerTo(Dir.UP);
    }

    void goDown() {
        movePlayerTo(Dir.DOWN);
    }

    void look() {
        showStr("You are in the " + player.describeLocation());
    }

    // utility method to display string if not empty
    // stripping any trailing newlines
    void showStr(String s) {
        if (s.endsWith("\n")) {
            s = s.substring(0, s.length() - 1);
        }
        if (!s.isEmpty()) {
            System.out.println(s);
        }
    }

    void showInventory() {
        showStr(player.inventory());
    }

    String lookAtOb(String obname) {
        return player.lookAt(obname);
    }

    String lookInOb(String obname) {
        return player.lookIn(obname);
    }

    public void showIntro() {
        String s;

        s = "You find yourself on the bridge of the HMS Starcrash,\n"
                + "an elite-class starship of Her Majesty's Royal Fleet.\n"
                + "There are no people on the bridge but there is a\n"
                + "console showing some information.\n"
                + "What do you want to do?\n"
                + "(Enter q to quit)";
        showStr(s);
        look();
    }

    public String runCommand(String inputstr) {
        List<String> wordlist;
        String s;
        String lowstr;

        s = "ok";
        lowstr = inputstr.trim().toLowerCase();

        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "You must enter a command";
            } else {
                wordlist = Parser.wordList(lowstr);
                s = Parser.parseCommand(wordlist);
            }
        }
        return s;
    }

    // Test..... BEGIN
    void showTest(String s) {
        showStr("> " + s);
        showStr(runCommand(s));

    }

    void showMass( int m ){
        showStr("Mass=" + m);
    }
    
    void test() {        
        // utility method to let me try out bits of code while developing the game            
        showStr("---BEGIN TEST---");
        showTest("w");
        showTest("get ring");
        showTest("get key");
        showTest("put ring in box");
        showTest("put key in box");
        showTest("get box");
        showTest("take chair");
        showTest("put chair in box");
        
        
       // ThingList tl = player.getLocation().flatten();
        
 
        showStr("---END TEST---");

    }
    // Test..... END

}
