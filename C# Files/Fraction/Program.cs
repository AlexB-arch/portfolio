using System;

class MainClass
{
    static void Main()
    {

        int w, n, d;

        Console.Write("Enter whole number for X: ");
        w = int.Parse(Console.ReadLine());
        Console.Write("Enter numerator for X: ");
        n = int.Parse(Console.ReadLine());
        Console.Write("Enter denominator for X: ");
        d = int.Parse(Console.ReadLine());
        Fraction X = new Fraction(w, n, d);

        Console.Write("Enter whole number for Y: ");
        w = int.Parse(Console.ReadLine());
        Console.Write("Enter numerator for Y: ");
        n = int.Parse(Console.ReadLine());
        Console.Write("Enter denominator for Y: ");
        d = int.Parse(Console.ReadLine());
        Fraction Y = new Fraction(w, n, d);

        Console.Write("\n");


        Console.WriteLine("X: {0}", X.Display());
        Console.WriteLine("Y: {0}", Y.Display());

        Fraction A = X + Y;
        Console.WriteLine("ADD: {0}", A.Display());

        Fraction S = X - Y;
        Console.WriteLine("SUB: {0}", S.Display());

        Fraction M = X * Y;
        Console.WriteLine("MUL: {0}", M.Display());

        Fraction D = X / Y;
        Console.WriteLine("DIV: {0}", D.Display());

    }
}


