import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple Calculator.
 */

public class CalculatorTest
{
    Calculator calc;
    
    @Before
    public void initialize() {
	calc = new Calculator();
    }
    
    @Test
    public void testAdd() 
    {
    	try {
	    int a = 2;
	    int b = 3;
	    int expect = calc.add(a, b);
	    assertEquals(a + b, expect );
	} catch (Exception e) {
	    System.out.println("testAdd catch");
	}
    }

    @Test
    public void testSubtract() 
    {
    	try {
	    int a = 2;
	    int b = 3;

	    // fix the following
	    //	    int expect = calc.subtract(a, b);
	    //	    assertEquals(a - b, expect );
	    
	    assertTrue( true ); // fix this
		} 
		catch (Exception e) {
	    System.out.println("testSubtract catch");
		}
    }

}









