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
		int actual = calc.add(a, b);
		assertEquals(5, actual);
	} catch (Exception e) {
	    System.out.println("testAdd1 catch");
		}
    }

	@Test
	public void testAdd2() {
		try {
			int a = 0;
			int b = 0;
			int actual = calc.add(a, b);
			assertEquals(0, actual);
		} catch (Exception e) {
			System.out.println("testAdd2 catch");
		}
	}

	@Test
	public void testAdd3() {
		try {
			int a = -1;
			int b = -1;
			int actual = calc.add(a, b);
			assertEquals(-2, actual);
		} catch (Exception e) {
			System.out.println("testAdd3 catch");
		}
	}

	@Test
	public void testAdd4() {
		try {
			int a = 5;
			int b = -1;
			int actual = calc.add(a, b);
			assertEquals(4, actual);
		} catch (Exception e) {
			System.out.println("testAdd4 catch");
		}
	}

	// Test for subtraction four different times
    @Test
    public void testSubtract1() 
    {
    	try {
	    int a = 2;
	    int b = 3;

	    // Fixed by giving assertEquals an expected and actual value returned by the method.
		int actual = calc.subtract(a, b);
	    assertEquals(-1, actual);
		} 
		catch (Exception e) {
	    	System.out.println("testSubtract1 catch");
		}
    }

	@Test
	public void testSubtract2() {
		try {
			int a = 0;
			int b = 0;
			int actual = calc.subtract(a, b);
			assertEquals(0, actual);
		} catch (Exception e) {
			System.out.println("testSubtract2 catch");
		}
	}

	@Test
	public void testSubtract3() {
		try {
			int a = -1;
			int b = -1;
			int actual = calc.subtract(a, b);
			assertEquals(0, actual);
		} catch (Exception e) {
			System.out.println("testSubtract3 catch");
		}
	}

	@Test
	public void testSubtract4() {
		try {
			int a = 3;
			int b = -1;
			int actual = calc.subtract(a, b);
			assertEquals(4, actual);
		} catch (Exception e) {
			System.out.println("testSubtract4 catch");
		}
	}

	// Test for multiplication four different times
	@Test
	public void testMultiply1() 
	{
		try {
	    int a = 2;
	    int b = 3;

		int actual = calc.multiply(a, b);
	    assertEquals(6, actual);
		} 
		catch (Exception e) {
	    	System.out.println("testMultiply1 catch");
		}
	}
	@Test
	public void testMultiply2() 
	{
		try {
			int a = 0;
			int b = 0;
			int actual = calc.multiply(a, b);
			assertEquals(0, actual);
		} catch (Exception e) {
			System.out.println("testMultiply2 catch");
		}
	}

	@Test
	public void testMultiply3() 
	{
		try {
			int a = -2;
			int b = -5;
			int actual = calc.multiply(a, b);
			assertEquals(10, actual);
		} catch (Exception e) {
			System.out.println("testMultiply3 catch");
		}
	}

	@Test
	public void testMultiply4() 
	{
		try {
			int a = 2;
			int b = -5;
			int actual = calc.multiply(a, b);
			assertEquals(-10, actual);
		} catch (Exception e) {
			System.out.println("testMultiply4 catch");
		}
	}

	// Test for division four different times
	//Side note: evaluating doubles for equality is deprecated so I will only be using ints.
	@Test
	public void testDivide1() 
	{
		try {
			int a = 2;
			int b = 2;
			int actual = calc.divide(a, b);
			assertEquals(1, actual);
		} catch (Exception e) {
			System.out.println("testDivide1 catch");
		}
	}

	@Test
	public void testDivide2() 
	{
		try {
			int a = 1;
			int b = 0;
			int actual = calc.divide(a, b);
			assertEquals(java.lang.ArithmeticException.class, actual);//Built in exception for dividing by zero
		} catch (Exception e) {
			System.out.println("testDivide2 catch");
		}
	}

	@Test
	public void testDivide3() 
	{
		try {
			int a = -2;
			int b = -2;
			int actual = calc.divide(a, b);
			assertEquals(1, actual);
		} catch (Exception e) {
			System.out.println("testDivide3 catch");
		}
	}

	@Test
	public void testDivide4() 
	{
		try {
			int a = 2;
			int b = -2;
			int actual = calc.divide(a, b);
			assertEquals(-1, actual);
		} catch (Exception e) {
			System.out.println("testDivide4 catch");
		}
	}

	@Test
	public void squared() 
	{
		try {
			int a = 2;
			int actual = calc.squared(a);
			assertEquals(4, actual);
		} catch (Exception e) {
			System.out.println("testSquared catch");
		}
	}
}









