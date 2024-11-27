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
 * This is an sample data file to which you may add words that
 * you want to be understood by your game. Currently it contains a very small
 * number of basic words which are likely to be needed in all games
 * You can add more words as paired elements where the first item of
 * each element is the word itself (a string) and the second item is
 * a word type as defined in the WT enum.
 *
 */
import globals.WT;
import java.util.HashMap;

public class VocabularyData implements java.io.Serializable {

    public static HashMap<String, WT> vocab = new HashMap<>();

    public static void initVocab() {
        // Nouns
        vocab.put("box", WT.NOUN);
        // Verbs       
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
        // Adjectives        
        vocab.put("small", WT.ADJECTIVE);
        vocab.put("tiny", WT.ADJECTIVE);
        vocab.put("big", WT.ADJECTIVE);
        // Articles
        vocab.put("a", WT.ARTICLE);
        vocab.put("an", WT.ARTICLE);
        vocab.put("some", WT.ARTICLE);
        vocab.put("the", WT.ARTICLE);
        // Prepositions
        vocab.put("in", WT.PREPOSITION);
        vocab.put("into", WT.PREPOSITION);
        vocab.put("at", WT.PREPOSITION);
        vocab.put("with", WT.PREPOSITION);
    }
}
