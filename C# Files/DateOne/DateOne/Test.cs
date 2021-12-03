using System;

class Program
{
    static void Main(string[] args)
    {


        Date a = new Date();
        a.Day = 25;
        a.Year = 2020;
        a.Month = 12;

        Date b = new Date();
        b.Day = 1;
        b.Year = 1996;
        b.Month = 12;

        a.DisplayUSFormat();
        b.DisplayUSFormat();

        Console.WriteLine(b < a);
        Console.WriteLine(a == b);

        Date d = new Date();
        d.Year = 1890;
        d.Month = 5;
        d.Day = 40;

        d.DisplayUSFormat();

        Console.WriteLine(d < a);

    }
}