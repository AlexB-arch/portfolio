/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book 
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *    http://www.bitwisebooks.com
 * 
 */
package mainloop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Huw
 */
public class MainLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;        

        in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("> ");
            input = in.readLine();            
            System.out.println("You entered '" + input + "'");
        } while (!"q".equals(input));
    }
    
}
