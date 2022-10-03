import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

       for (int i = 0; i < 6; i++){
           turtle.seen();

           // Verify total count of the turtles courage.
           System.out.println(turtle.allCourages());

              assertEquals(6, turtle.allCourages());
       }

    }

    @Test
    public void testLose(){

        if (turtle.courages == 3){
            turtle.lose("L");
            assertEquals(2, turtle.bravery());
        }
    }

    @Test
    public void testExplodes(){

        for (int i = 0; i < 7; i++){
            turtle.seen();
            System.out.println(turtle.courages);
        }

        if (turtle.courages > 3){
            turtle.explodes();
            System.out.println(turtle.socialstatus(turtle.courages));
            // Print number of courages before assert.
            System.out.println(turtle.courages);

            assertEquals(-3, turtle.bravery());
        }
    }

}