using System;

class Program{
    static void Main(string[] args){

        string length, width;
        double price, area;
    
        //Accepts  length input, then converts to decimal.
        Console.WriteLine("Room Length: ");
        length = Console.ReadLine();
        Convert.ToDouble(length);

        //Accepts width input, then converts to decimal.
        Console.WriteLine("Room Width: ");
        width = Console.ReadLine();
        Convert.ToDouble(width);

        //Calculates area of the room.
        area = (Convert.ToDouble(length) * Convert.ToDouble(width));

        //Calculates the price of the carpet by square footage.
        price = area * 3.50;

        Console.WriteLine("The square footage of the room is {0} and the cost is {1:C}", area, price);
    }
}