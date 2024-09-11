import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * Modern devs say to start with tests.
 * 
 * @Before runs before the @Test tags
 */

public class CalcTest{

  @Test
  public void testAdd1(){
    assertEquals(5, Calculator.add(2, 3));
  }

  @Test
  public void testAdd2(){
    assertEquals(7, Calculator.add(4, 3));
  }

  @Test
  public void testAdd3(){
    assertEquals(0, Calculator.add(0, 0));
  }

  @Test
  public void testSubstract1(){
    assertEquals(2, Calculator.substract(5, 3));
  }

  @Test
  public void testSubstract2(){
    assertEquals(3, Calculator.substract(-1, -4));
  }

  @Test
  public void testSubstract3(){
    assertEquals(0, Calculator.substract(0, 0));
  }

  @Test
  public void testDivide1(){
    assertEquals(2.0, Calculator.divide(6, 3), 0.0);
  }

  @Test
  public void testDivide2(){
    assertEquals(0.0, Calculator.divide(0, 3), 0.0);
  }

  @Test
  public void testDivide3(){
    try{
      Calculator.divide(5, 0);
    } catch (IllegalArgumentException e){
      assertEquals("Cannot divide by zero", e.getMessage());
    }
  }

  @Test
  public void testDivide4(){
    assertEquals(-3, Calculator.divide(6, -2), 0.0);
  }

  @Test
  public void testMultiply1(){
    assertEquals(6, Calculator.multiply(2, 3));
  }

  @Test
  public void testMultiply2(){
    assertEquals(0, Calculator.multiply(0, 3));
  }

  @Test
  public void testMultiply3(){
    assertEquals(-27, Calculator.multiply(9, -3));
  }

  @Test
  public void testModulo1(){
    assertEquals(1, Calculator.modulo(5, 2), 0.0);
  }

  @Test
  public void testModulo2(){
    assertEquals(0, Calculator.modulo(0, 3), 0.0);
  }

  @Test
  public void testModulo3(){
    try{
      Calculator.modulo(5, 0);
    } catch (IllegalArgumentException e){
      assertEquals("Cannot divide by zero", e.getMessage());
    }
  }
}