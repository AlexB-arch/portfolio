/* axb19c - Alex Burgos
 *  Maven Calculator with JUnit
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Calculator");
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int substract(int a, int b) {
        return a - b;
    }

    public static double divide(int a, int b) {
        if (b == 0)
            throw new IllegalArgumentException("Cannot divide by zero");
        

        return a / b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double modulo(int a, int b) {
        if (b == 0)
            throw new IllegalArgumentException("Cannot divide by zero"); 
             
        return a % b;
    }
}