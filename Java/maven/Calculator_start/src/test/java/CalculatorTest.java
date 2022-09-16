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

  //  Test for addition four different times 
    @Test
	public void testAdd1() {
    try {
		int a = 2;
		int b = 3;
		int expect = calc.add(a, b);
		assertEquals(expect, 5);
	} catch (Exception e) {
	    System.out.println("testAdd catch");
		}
    }

	@Test
	public void testAdd2() {
		try {
			int a = 0;
			int b = 0;
			int expect = calc.add(a, b);
			assertEquals(expect, 0);
		} catch (Exception e) {
			System.out.println("testAdd catch");
		}
	}

	@Test
	public void testAdd3() {
		try {
			int a = -1;
			int b = -1;
			int expect = calc.add(a, b);
			assertEquals(expect, a + b);
		} catch (Exception e) {
			System.out.println("testAdd catch");
		}
	}

	@Test
	public void testAdd4() {
		try {
			int a = 5;
			int b = -1;
			int expect = calc.add(a, b);
			assertEquals(expect, a + b);
		} catch (Exception e) {
			System.out.println("testAdd catch");
		}
	}

	// Test for subtraction four different times
    @Test
    public void testSubtract1() 
    {
    	try {
	    int a = 2;
	    int b = 3;

	    // Fixed by giving assertEquals an expected and actual value.
		int expect = calc.subtract(a, b);
	    assertEquals(expect, a - b);
	    //assertTrue(expect == a - b); // This returns a boolean like assertEqual, but doesn't give a message. 
		} 
		catch (Exception e) {
	    	System.out.println("testSubtract catch");
		}
    }

	@Test
	public void testSubtract2() {
		try {
			int a = 0;
			int b = 0;
			int expect = calc.subtract(a, b);
			assertEquals(expect, a - b);
		} catch (Exception e) {
			System.out.println("testSubtract catch");
		}
	}

	@Test
	public void testSubtract3() {
		try {
			int a = -1;
			int b = -1;
			int expect = calc.subtract(a, b);
			assertEquals(expect, a - b);
		} catch (Exception e) {
			System.out.println("testSubtract catch");
		}
	}

	@Test
	public void testSubtract4() {
		try {
			int a = 3;
			int b = -1;
			int expect = calc.subtract(a, b);
			assertEquals(expect, a - b);
		} catch (Exception e) {
			System.out.println("testSubtract catch");
		}
	}

	// Test for multiplication four different times
	@Test
	public void testMultiply1() 
	{
		try {
	    int a = 2;
	    int b = 3;

	    // Fixed by giving assertEquals an expected and actual value.
		int expect = calc.multiply(a, b);
	    assertEquals(expect, a * b);
	    //assertTrue(expect == a * b); // This returns a boolean like assertEqual, but doesn't give a message. 
		} 
		catch (Exception e) {
	    	System.out.println("testMultiply catch");
		}
	}
	@Test
	public void testMultiply2() 
	{
		try {
			int a = 0;
			int b = 0;
			int expect = calc.multiply(a, b);
			assertEquals(expect, a * b);
		} catch (Exception e) {
			System.out.println("testMultiply catch");
		}
	}

	@Test
	public void testMultiply3() 
	{
		try {
			int a = -2;
			int b = -5;
			int expect = calc.multiply(a, b);
			assertEquals(expect, a * b);
		} catch (Exception e) {
			System.out.println("testMultiply catch");
		}
	}

	@Test
	public void testMultiply4() 
	{
		try {
			int a = 2;
			int b = -5;
			int expect = calc.multiply(a, b);
			assertEquals(expect, a * b);
		} catch (Exception e) {
			System.out.println("testMultiply catch");
		}
	}

	// Test for division four different times
	@Test
	public void testDivide1() 
	{
		try {
			int a = 2;
			int b = 3;
			int expect = calc.divide(a, b);
			assertEquals(expect, a / b);
		} catch (Exception e) {
			System.out.println("testDivide catch");
		}
	}

	@Test
	public void testDivide2() 
	{
		try {
			int a = 1;
			int b = 0;
			int expect = calc.divide(a, b);
			assertEquals(expect, a / b);
		} catch (Exception e) {
			System.out.println("testDivide catch");
		}
	}

	@Test
	public void testDivide3() 
	{
		try {
			int a = -2;
			int b = -5;
			int expect = calc.divide(a, b);
			assertEquals(expect, a / b);
		} catch (Exception e) {
			System.out.println("testDivide catch");
		}
	}

	@Test
	public void testDivide4() 
	{
		try {
			int a = 2;
			int b = -5;
			int expect = calc.divide(a, b);
			assertEquals(expect, a / b);
		} catch (Exception e) {
			System.out.println("testDivide catch");
		}
	}
}









