using System;

class TestCar
{

    public static void Main(string[] args)
    {

        Car C1 = new Car(11111111, "Toyota", "Camry", "Red", 22030.50);
        Car C2 = new Car(22222222, "Nissan", "Altima", "Grey", 15000.00);

        Console.WriteLine("C1 id: {0}", C1.getIdNumber());
        Console.WriteLine("C1 make: {0}", C1.getMake());
        Console.WriteLine("C1 model: {0}", C1.getModel());
        Console.WriteLine("C1 value: {0}", C1.getValue());

        Console.WriteLine("\n");

        Console.WriteLine("C2 id: {0}", C2.getIdNumber());
        Console.WriteLine("C2 make: {0}", C2.getMake());
        Console.WriteLine("C2 model: {0}", C2.getModel());
        Console.WriteLine("C2 value: {0}", C2.getValue());
    }
}