/*
 * Sample Java file by Huw Collingbourne
 * 
 * This code (and other sample code) accompanies the book 
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */

package game;

import gameobjects.Actor;
import gameobjects.Room;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Parser {  

    static List<String> commands = new ArrayList<>(Arrays.asList(
            "take", "drop", "look", "l", "i", "inventory",
            "n", "s", "w", "e",
            "save", "load"));
    static List<String> objects = new ArrayList<>(Arrays.asList("carrot", "sausage",
            "paper", "pencil", "ring", "wombat"));

    
     static String processVerbNoun(List<String> wordlist) {
        String verb;
        String noun;
        String msg = "";
        boolean error = false;
        verb = wordlist.get(0);
        noun = wordlist.get(1);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
            error = true;
        }
        if (!objects.contains(noun)) {
            msg += (noun + " is not a known noun!");
            error = true;
        }
        if (!error) {
            switch (verb) {
                case "take":
                    msg = AdventureGame.game.takeOb(noun);
                    break;
                case "drop":
                    msg = AdventureGame.game.dropOb(noun);
                    break;
                default:
                    msg += " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }
     
    static String processVerb(List<String> wordlist) {
        String verb;
        String msg = "";
        verb = wordlist.get(0);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        } else {
            switch (verb) {
                case "n":
                    AdventureGame.game.goN();
                    break;
                case "s":
                    AdventureGame.game.goS();
                    break;
                case "w":
                    AdventureGame.game.goW();
                    break;
                case "e":
                    AdventureGame.game.goE();
                    break;
                case "l":
                case "look":
                    AdventureGame.game.look();
                    break;
                case "inventory":
                case "i":
                    AdventureGame.game.showInventory();
                    break;               
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

}
