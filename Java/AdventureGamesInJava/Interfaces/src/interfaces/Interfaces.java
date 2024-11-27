/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book 
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *    http://www.bitwisebooks.com
 * 
 */


package interfaces;

interface Animal {
    public void talk(); 
    public void move(); 
}

interface Pet {
    public String getName();    
}

class Cow implements Animal {

    public void talk() {        
        System.out.println("Moooo");
    }

    public void move() {        
        System.out.println("Plod, plod, plod...");
    }
}

class Dog implements Animal, Pet {
    private String name;
    
    public Dog(String aName){
        name = aName;
    }
    public void talk() {        
        System.out.println("Woof!");
    }

    public void move() {        
        System.out.println("Leap, walk, sniff, leap, walk...");
    }
    
    public String getName(){
        return name;
    };        
    
    public void wagTail(){
        System.out.println("Wag, wag, wag");
    }
}

public class Interfaces {
    
    public static void main(String[] args) {
        Cow aCow = new Cow();         
        aCow.talk();
        aCow.move();
        
        Dog rover = new Dog("Rover");
        System.out.println(rover.getName());
        rover.talk();
        rover.move();
        rover.wagTail();
    }

}
