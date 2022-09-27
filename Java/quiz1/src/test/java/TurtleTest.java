import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurtleTest{
    
    Turtle turtle = new Turtle();

    @Test
    public void testSeen(){
        turtle.seen();
        assertEquals(-2, turtle.bravery());

    }

    @Test
    public void testSocialStatus(){
        assertEquals("Disliked", turtle.socialstatus(turtle.courages));
    }

    @Test
    public void testBravery(){
        assertEquals(-3, turtle.bravery());
    }

    @Test
    public void testAllCourages(){
        turtle.seen();
        assertEquals(1, turtle.allCourages());
    }

}