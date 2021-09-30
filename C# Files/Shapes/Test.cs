using System;

class Program
{
    static void Main(string[] args)
    {
        Box b = new Box("RED", 1, 5, 3, -1);    // left, top, right, bottom bounds of the box

        b.setLeft(2.5);                     // set the  box's left side coordinate
        double left = b.getLeft();          // get box's left side coordinate
                                            // similar for: right, top, bottom

        string str = b.render();            // should return: "Box(RED,2.5,5,3,-1)"
    }
}