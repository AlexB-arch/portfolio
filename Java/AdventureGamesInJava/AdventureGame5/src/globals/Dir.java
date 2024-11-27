/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */

package globals;

public enum Dir {
    NORTH, 
    SOUTH, 
    EAST, 
    WEST,
    UP,
    DOWN;
    /*
        NOEXIT has an integer value which is convenient when initializing the
        'Exit' fields in Room objects. All valid exists indicate a Room number
        whereas NOEXIT is -1.
    */
    public static final int NOEXIT = -1;
};