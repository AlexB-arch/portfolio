import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.Console;
import java.security.Principal;

public class TurtleTest{
    
    Turtle turtle = new Turtle();

    @Test
    public void testTurtle(){
        assertEquals(-3, turtle.courages);
        assertEquals(0, turtle.allCourages);
    }

    @Test
    public void testSeen(){
        assertEquals(-3, turtle.courages);

        while (turtle.courages < 3){
            turtle.seen();
        }

        assertEquals(3, turtle.bravery());
        assertEquals(6, turtle.allCourages());
    }

    @Test
    public void testSocialStatus(){

        if (turtle.courages == 3){
            assertEquals("Loved", turtle.socialstatus(turtle.courages));
        }
        else if (turtle.courages > 3){
            assertEquals("Explodes like Master Ugwe", turtle.socialstatus(turtle.courages));
        }
        else{
            assertEquals("Disliked", turtle.socialstatus(turtle.courages));
        }
    }

    @Test
    public void testBravery(){

        assertEquals(-3, turtle.bravery());

        turtle.seen();

        assertEquals(-2, turtle.bravery());
    }

    @Test
    public void testAllCourages(){

        assertEquals(0, turtle.allCourages());

        turtle.seen();


        assertEquals(1, turtle.allCourages());
        assertEquals("Disliked", turtle.socialstatus(turtle.courages));

    }

    @Test
    public void testLose(){

        if (turtle.courages == 3){
            turtle.lose("L");
            assertEquals(2, turtle.bravery());
        }
    }

}