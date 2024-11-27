/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package game;

import java.util.*;     // required for ArrayList
import gameobjects.Actor;
import gameobjects.Room;
import gameobjects.Thing;
import gameobjects.ThingList;
import gameobjects.Treasure;
import globals.Dir;

public class Game implements java.io.Serializable {

    private ArrayList<Room> map; // the map - an ArrayList of Rooms    
    private Actor player;  // the player - provides 'first person perspective'  

    public Game() {
        this.map = new ArrayList<Room>(); // TODO: Make map a Generic list of Room
        // --- construct a new adventure ---

        ThingList trollRoomList = new ThingList();
        trollRoomList.add(new Treasure("carrot", "It is a very crunchy carrot", 1));

        ThingList forestList = new ThingList();
        forestList.add(new Treasure("sausage", "It is a plump pork sausage", 10));

        ThingList caveList = new ThingList();
        caveList.add(new Treasure("paper", "Someone has written a message on the scrap of paper using a blunt pencil. It says 'This space is intentionally left blank'", 1));
        caveList.add(new Treasure("pencil", "This pencil is so blunt that it can no longer be used to write.", 1));

        ThingList dungeonList = new ThingList();
        dungeonList.add(new Treasure("ring", "It is a ring of great power.", 500));
        dungeonList.add(new Treasure("wombat", "It's a cuddly little wombat. It is squeaking gently to itself.", 700));

        ThingList playerlist = new ThingList();
        // Add Rooms to the map
        //                 Room( name,   description,                             N,        S,      W,      E )
        map.add(new Room("Troll Room", "A dank room that smells of troll", Dir.NOEXIT, 2, Dir.NOEXIT, 1, trollRoomList));
        map.add(new Room("Forest", "A leafy woodland", Dir.NOEXIT, Dir.NOEXIT, 0, Dir.NOEXIT, forestList));
        map.add(new Room("Cave", "A dismal cave with walls covered in luminous moss", 0, Dir.NOEXIT, Dir.NOEXIT, 3, caveList));
        map.add(new Room("Dungeon", "A nasty, dark cell", Dir.NOEXIT, Dir.NOEXIT, 2, Dir.NOEXIT, dungeonList));

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

    // take and drop
    private void transferOb(Thing t, ThingList fromlist, ThingList tolist) {
        fromlist.remove(t);
        tolist.add(t);
    }

    String takeOb(String obname) {
        String retStr = "";
        Thing t = player.getLocation().getThings().thisOb(obname);
        
        if (obname.equals("")) {
            obname = "nameless object"; // if no object specified
        }
        if (t == null) {
            retStr = "There is no " + obname + " here!";
        } else {
            transferOb(t, player.getLocation().getThings(), player.getThings());
            retStr = obname + " taken!";
        }
        return retStr;
    }

    String dropOb(String obname) {
        String retStr = "";
        Thing t = player.getThings().thisOb(obname);
        
        if (obname.equals("")) {
            retStr = "You'll have to tell me which object you want to drop!"; // if no object specified
        } else if (t == null) {
            retStr = "You haven't got one of those!";
        } else {
            transferOb(t, player.getThings(), player.getLocation().getThings());
            retStr = obname + " dropped!";
        }
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

    void look() {
        showStr("You are in the " + getPlayer().getLocation().describe());
    }

    void showStr(String s) {
        System.out.println(s);
    }    

    void showInventory() {
        showStr("You have " + getPlayer().getThings().describeThings());
    }
       

    private String parseCommand(List<String> wordlist) {
        String msg;
        
        if (wordlist.size() == 1) {           
           msg = Parser.processVerb(wordlist);
        } else if (wordlist.size() == 2) {           
            msg = Parser.processVerbNoun(wordlist);
        } else {
            msg = "Only 2 word commands allowed!";
        }
        return msg;
    }

    private static List<String> wordList(String input) {        
        String delims = "[ \t,.:;?!\"']+"; 
        List<String> strlist = new ArrayList<>();      
        String[] words = input.split(delims);
    
        for (String word : words) {
            strlist.add(word);
        }        
        return strlist;
    }

    public void showIntro() {
        String s;
        
        s = "You have fallen down a rabbit hole and arrived in\n"
                + "an underground cavern that smells strongly of troll.\n"
                + "Where do you want to go? [Enter n, s, w or e]?\n"
                + "(or enter q to quit)";
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
                wordlist = wordList(lowstr);
                s = parseCommand(wordlist);
            }
        }
        return s;
    }

}
