/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */
package game.data;

import globals.WT;
import java.util.HashMap;

public class VocabularyData implements java.io.Serializable {   

    public static HashMap<String, WT> vocab = new HashMap<>();
    
    public static void initVocab() {
        vocab.put("bed", WT.NOUN);
        vocab.put("box", WT.NOUN);
        vocab.put("button", WT.NOUN);
        vocab.put("card", WT.NOUN);
        vocab.put("chair", WT.NOUN);
        vocab.put("coin", WT.NOUN);
        vocab.put("computer", WT.NOUN);
        vocab.put("console", WT.NOUN);
        vocab.put("cupboard", WT.NOUN);
        vocab.put("desk", WT.NOUN);
        vocab.put("door", WT.NOUN);
        vocab.put("key", WT.NOUN);
        vocab.put("knife", WT.NOUN);
        vocab.put("lamp", WT.NOUN);
        vocab.put("leaflet", WT.NOUN);
        vocab.put("lever", WT.NOUN);
        vocab.put("lights", WT.NOUN);
        vocab.put("paper", WT.NOUN);
        vocab.put("pencil", WT.NOUN);
        vocab.put("plant", WT.NOUN);
        vocab.put("plants", WT.NOUN);
        vocab.put("ring", WT.NOUN);
        vocab.put("screen", WT.NOUN);
        vocab.put("sign", WT.NOUN);
        vocab.put("slot", WT.NOUN);
        vocab.put("table", WT.NOUN);
        vocab.put("tree", WT.NOUN);
        vocab.put("viewscreen", WT.NOUN);
        vocab.put("wombat", WT.NOUN);
        vocab.put("test", WT.VERB);
        vocab.put("get", WT.VERB);
        vocab.put("i", WT.VERB);
        vocab.put("inventory", WT.VERB);
        vocab.put("take", WT.VERB);
        vocab.put("drop", WT.VERB);
        vocab.put("put", WT.VERB);
        vocab.put("l", WT.VERB);
        vocab.put("look", WT.VERB);
        vocab.put("lock", WT.VERB);
        vocab.put("unlock", WT.VERB);
        vocab.put("open", WT.VERB);
        vocab.put("close", WT.VERB);
        vocab.put("press", WT.VERB);
        vocab.put("pull", WT.VERB);
        vocab.put("push", WT.VERB);
        vocab.put("n", WT.VERB);
        vocab.put("s", WT.VERB);
        vocab.put("w", WT.VERB);
        vocab.put("e", WT.VERB);
        vocab.put("up", WT.VERB);
        vocab.put("u", WT.VERB);
        vocab.put("down", WT.VERB);
        vocab.put("d", WT.VERB);
        vocab.put("q", WT.VERB);
        vocab.put("quit", WT.VERB);
        vocab.put("activation", WT.ADJECTIVE);
        vocab.put("small", WT.ADJECTIVE);
        vocab.put("tiny", WT.ADJECTIVE);
        vocab.put("big", WT.ADJECTIVE);
        vocab.put("cardboard", WT.ADJECTIVE);
        vocab.put("display", WT.ADJECTIVE);
        vocab.put("huge", WT.ADJECTIVE);
        vocab.put("metal", WT.ADJECTIVE);
        vocab.put("onyx", WT.ADJECTIVE);
        vocab.put("pitcher", WT.ADJECTIVE);
        vocab.put("plastic", WT.ADJECTIVE);
        vocab.put("spiky", WT.ADJECTIVE);
        vocab.put("gold", WT.ADJECTIVE);
        vocab.put("silver", WT.ADJECTIVE);
        vocab.put("wooden", WT.ADJECTIVE);
        vocab.put("a", WT.ARTICLE);
        vocab.put("an", WT.ARTICLE);
        vocab.put("some", WT.ARTICLE);
        vocab.put("the", WT.ARTICLE);
        vocab.put("in", WT.PREPOSITION);
        vocab.put("into", WT.PREPOSITION);
        vocab.put("at", WT.PREPOSITION);        
        vocab.put("with", WT.PREPOSITION);        
    }
}
