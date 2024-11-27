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
import gameobjects.Treasure;
import globals.Dir;
import globals.ThingAndThingHolder;

public class Game implements java.io.Serializable {

    private ArrayList<Room> map; // the map - an ArrayList of Rooms    
    private Actor player;  // the player - provides 'first person perspective'  

    public Game() {
        Parser.initVocab();
        this.map = new ArrayList<Room>();
        // --- construct a new adventure ---

        ThingList trollRoomList = new ThingList("trollRoomList");
        trollRoomList.add(new Treasure("carrot", "It is a very crunchy carrot", 1));
        trollRoomList.add(new Thing("tree", "It is a very big tree", false, false));
        trollRoomList.add(new ContainerThing("sack", "a smelly old sack", true, true, true, true, new ThingList("sackList")));
        trollRoomList.add(new ContainerThing("bowl", "a brass bowl", true, true, false, true, new ThingList("bowlList")));

        ThingList forestList = new ThingList("forestList");
        forestList.add(new Treasure("sausage", "It is a plump pork sausage", 10));

        ThingList caveList = new ThingList("caveList");
        caveList.add(new Treasure("paper", "Someone has written a message on the scrap of paper using a blunt pencil. It says 'This space is intentionally left blank'", 1));
        caveList.add(new Treasure("pencil", "This pencil is so blunt that it can no longer be used to write.", 1));

        ThingList dungeonList = new ThingList("dungeonList");
        dungeonList.add(new Treasure("ring", "It is a ring of great power.", 500));
        dungeonList.add(new Treasure("wombat", "It's a cuddly little wombat. It is squeaking gently to itself.", 700));

        ThingList playerlist = new ThingList("playerlist");

        // Map:
        //
        // Troll Room --- Forest 
        //   | 
        // Cave --------- Shed 
        //  | 
        //  V 
        // Dungeon
        //                 Room( name,   description,              N,        S,      W,      E,  [Up], [Down])
        // 0
        map.add(new Room("Troll Room", "A dank room that smells of troll", Dir.NOEXIT, 2, Dir.NOEXIT, 1, trollRoomList));
        // 1
        map.add(new Room("Forest", "A leafy woodland", Dir.NOEXIT, Dir.NOEXIT, 0, Dir.NOEXIT, forestList));
        // 2
        map.add(new Room("Cave", "A dismal cave with walls covered in luminous moss", 0, Dir.NOEXIT, Dir.NOEXIT, 3, Dir.NOEXIT, 4, caveList));
        // 3 
        map.add(new Room("Shed", "An old, wooden shed", Dir.NOEXIT, Dir.NOEXIT, 2, Dir.NOEXIT, new ThingList("shedList")));
        // 4 
        map.add(new Room("Dungeon", "A nasty, dark cell", Dir.NOEXIT, Dir.NOEXIT, Dir.NOEXIT, Dir.NOEXIT, 2, Dir.NOEXIT, new ThingList("dungeonList")));

        // create player and place in Room 0 (i.e. the Room at 0 index of map)
        player = new Actor("player", "a loveable game-player", playerlist, map.get(0));
    }

    // access methods
    // map
    private ArrayList getMap() {
        return map;
    }

    private void setMap(ArrayList aMap) {
        map = aMap;
    }

    // player
    private Actor getPlayer() {
        return player;
    }

    private void setPlayer(Actor aPlayer) {
        player = aPlayer;
    }

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
        String retStr = "";
        retStr = player.take(obname);
        return retStr;
    }

    String dropOb(String obname) {
        String retStr = "";
        retStr = player.drop(obname);
        return retStr;
    }

    // move a Person (typically the player) to a Room
    private void moveActorTo(Actor p, Room aRoom) {
        p.setLocation(aRoom);
    }

    // move an Actor in direction 'dir'
    private int moveTo(Actor anActor, Dir dir) {
        // return: Constant representing the room number moved to
        // or NOEXIT
        //
        // try to move any Person (typically but not necessarily player)
        // in direction indicated by dir
        Room r = anActor.getLocation();
        int exit;

        switch (dir) {
            case NORTH:
                exit = r.getN();
                break;
            case SOUTH:
                exit = r.getS();
                break;
            case EAST:
                exit = r.getE();
                break;
            case WEST:
                exit = r.getW();
                break;
            case UP:
                exit = r.getUp();
                break;
            case DOWN:
                exit = r.getDown();
                break;
            default:
                exit = Dir.NOEXIT; // noexit - stay in same room
                break;
        }
        if (exit != Dir.NOEXIT) {
            moveActorTo(anActor, map.get(exit));
        }
        return exit;
    }

    void movePlayerTo(Dir dir) {
        // if roomNumber = NOEXIT, display a special message, otherwise
        // display text (e.g. name and description of room)                
        if (moveTo(player, dir) == Dir.NOEXIT) {
            showStr("No Exit!");
        } else {
            look();
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

        s = "You have fallen down a rabbit hole and arrived in\n"
                + "an underground cavern that smells strongly of troll.\n"
                + "Where do you want to go?\n"
                + "Enter: n, s, w, e, up, down\n"
                + "or q to quit.";
        showStr(s);
        look();
    }

    public String runCommand(String inputstr) {
        List<String> wordlist;
        String s = "ok";
        String lowstr = inputstr.trim().toLowerCase();

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
    void showVisibleThings(ThingList tl) {
        for (Thing t : tl) {
            showStr(t.getName());
            if ((t instanceof ContainerThing) && ((ContainerThing) t).isOpen()) {
                showVisibleThings(((ContainerThing) t).getThings());
            }
        }
    }

    void showThingsInRoom() { // shows only 'top-level' objects in list
        ThingList tl = player.getLocation().getThings();
        for (Thing t : tl) {
            showStr(t.getName());
        }
    }

    void showTest(String s) {
        showStr("> " + s);
        showStr(runCommand(s));

    }

    void test() {
        // utility method to let me try out bits of code while developing the game  
        // Here I can enter commands, just as the player would when
        // playing the game. the showTest() method shows the command and the
        // game's reply...
        showStr("---BEGIN TEST---");
        showTest("get carrot");
        showTest("get bowl");
        showTest("put carrot in bowl");
        showTest("put bowl in sack");
        showTest("drop sack");
        /*
         * showTest("get carrot");
         * showTest("put carrot in bowl");
         * showTest("put carrot in bowl");
         * showTest("get sack");
         * showTest("put sack in carrot");
         * showTest("put sack in sack");
         * showTest("close sack");
         * showTest("put bowl in sack");
         * showTest("open sack");
         * showTest("put bowl in sack");
         * showTest("i");
         * showTest("put sack in bowl");
         * showTest("i");
         */
        System.out.println("showThingsInRoom()");
        showThingsInRoom(); // this works ok when no objects are in containers    
        System.out.println("showVisibleThings()");
        showVisibleThings(player.getLocation().getThings()); // to show things inside other things 
        showStr("---END TEST---");
    }
    // Test..... END

}
