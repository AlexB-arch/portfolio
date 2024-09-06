import calculator.Main;
import org.junit.Test;
import static org.junit.Assert.*;

public class MethodTesting {
    
    // Test the add method
    @Test
    public void testAdd() {
        assertEquals(4, Main.add(2, 2));
        assertEquals(7, Main.add(5, 2));
        assertEquals(1, Main.add(1, 0));
    }
    
    // Test the substract method
    @Test
    public void testSubstract() {
        assertEquals(2, Main.substract(4, 2));
        assertEquals(3, Main.substract(5, 2));
        assertEquals(1, Main.substract(1, 0));
    }
    
    // Test the divide method
    @Test
    public void testDivide() {
        assertEquals(2, Main.divide(4, 2));
        assertEquals(2.5, Main.divide(5, 2), 0.1);
        assertEquals(0.5, Main.divide(1, 2), 0.1);
    }
    
    // Test the multiply method
    @Test
    public void testMultiply() {
        assertEquals(4, Main.multiply(2, 2));
        assertEquals(10, Main.multiply(5, 2));
        assertEquals(0, Main.multiply(1, 0));
    }
    
    // Test the divide method with zero
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        Main.divide(4, 0);
    }
}
