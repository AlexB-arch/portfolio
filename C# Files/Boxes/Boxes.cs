using System;

class Box
{
    public int height;
    public int width;
    public int depth;

    public Box()
    {
        height = 1;
        width = 1;
        depth = 1;
    }
}

class Book
{
    int pageNum;
    string title;
    double price, tax;

}

class Program
{
static void Main(string[] args)
    {
        //Sets the height of the box without having specific parameters.
        Box b1 = new Box { height = 3 };
        Box b2 = new Box { width = 4 };
        Box b3 = new Box { depth = 3 };

        Display(1, b1);
    }

    internal static void Display(int n, Box b)
    {
        Console.WriteLine("Box {0} width: {1}, height: {2}, depth: {3}",
            n ,b.width, b.height, b.depth);
    }
}

/*  Using "this" allows you to reuse the same line of code without having to specify
 *  the class of method you're using.
 *  
 *  example: void SetPrice(double price)
 *  {
 *      this.price = price;
 *  }
 *  
 *  Another way to use "this" is to use it to overload constructors. 
 *  
 *  example: public Box() : this(height, width, depth){}
 *  
 *  That will allow you to construct the class using less code.
 */