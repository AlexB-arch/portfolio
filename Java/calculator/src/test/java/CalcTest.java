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
    assertEquals(5, Main.add(2, 3));
  }

  @Test
  public void testAdd2(){
    assertEquals(7, Main.add(4, 3));
  }

  @Test
  public void testAdd3(){
    assertEquals(0, 0, 0);
  }

  @Test
  public void testSubstract1(){
    assertEquals(2, Main.substract(5, 3));
  }

  @Test
  public void testSubstract2(){
    assertEquals(3, Main.substract(-1, -4));
  }

  @Test
  public void testSubstract3(){
    assertEquals(0, Main.substract(0, 0));
  }

  @Test
  public void testDivide1(){
    assertEquals(2.0, Main.divide(6, 3), 0.0);
  }

  @Test
  public void testDivide2(){
    assertEquals(0.0, Main.divide(0, 3), 0.0);
  }

  @Test
  public void testDivide3(){
    try{
      Main.divide(5, 0);
    } catch (IllegalArgumentException e){
      assertEquals("Cannot divide by zero", e.getMessage());
    }
  }

  @Test
  public void testDivide4(){
    assertEquals(-3, Main.divide(6, -2), 0.0);
  }

  @Test
  public void testMultiply1(){
    assertEquals(6, Main.multiply(2, 3));
  }

  @Test
  public void testMultiply2(){
    assertEquals(0, Main.multiply(0, 3));
  }

  @Test
  public void testMultiply3(){
    assertEquals(-27, Main.multiply(9, -3));
  }

  @Test
  public void testModulo1(){
    assertEquals(1, Main.modulo(5, 2), 0.0);
  }

  @Test
  public void testModulo2(){
    assertEquals(0, Main.modulo(0, 3), 0.0);
  }

  @Test
  public void testModulo3(){
    try{
      Main.modulo(5, 0);
    } catch (IllegalArgumentException e){
      assertEquals("Cannot divide by zero", e.getMessage());
    }
  }

}