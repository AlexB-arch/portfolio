import org.junit.Test;
import org.junit.Assert;

public class FlyTest {

    //Instanciate the class
    Fly fly = new Fly();

    @Test
    public void testCloseEnough(){
     
    }

    @Test
    public void testDirections() {
        
        assertEquals(0.0, fly.directions("North"), 0.0);
    }
}