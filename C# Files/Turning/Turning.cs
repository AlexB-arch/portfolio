using System;

//Interface to be used by the different classes.
public interface ITurnable
{
    void Turn();
}

//Interfaces are inherited just like classes, by a colon next to the class.
//Classes can inherit many interfaces, and they do not need to be overriden.
public class Page : ITurnable
{
    public void Turn()
    {
        Console.WriteLine("You turn a page in a book");
    }
}

public class Corner : ITurnable
{
    public void Turn()
    {
        Console.WriteLine("You turn corners to go around the block");
    }
}

public class Pancake : ITurnable
{
    public void Turn()
    {
        Console.WriteLine("You turn a pancake when it's done on one side");
    }
}

public class Leaf : ITurnable
{
    public void Turn()
    {
        Console.WriteLine("A leaf turns colors in the fall");
    }
} 