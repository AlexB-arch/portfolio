using System;
class TurningDemo
{
    public static void Main()
    {
        Page aPage = new Page();
        Corner aCorner = new Corner();
        Pancake aPancake = new Pancake();
        Leaf aLeaf = new Leaf();
        Console.Write("Page info: ");
        aPage.Turn();
        Console.Write("Corner info: ");
        aCorner.Turn();
        Console.Write("Pancake info: ");
        aPancake.Turn();
        Console.Write("Leaf info: ");
        aLeaf.Turn();
    }
}