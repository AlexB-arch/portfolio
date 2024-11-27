/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package gameobjects;

import java.util.ArrayList;

public class ThingList extends ArrayList<Thing> implements java.io.Serializable{
   
    private String name; // useful for debugging
    
    public ThingList(String aName){
        super();
        name = aName;
    }
    
     public String getName() {
        return name;
    }
         
}
