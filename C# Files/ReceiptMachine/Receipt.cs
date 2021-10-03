using System;

    class Program
    {
        static void Main(string[] args)
        {

        string name, street, city, state, zipCode, orderQuantity;
        const double tax = 0.07, blender = 39.95;
        int qty;
        double total, plusTax, due;

        //Ask for customer's name.
        Console.Write("Enter your name: ");
        name = Console.ReadLine();

        //Ask for customer's street address.
        Console.Write("Street address: ");
        street = Console.ReadLine();

        //Ask for customer's city.
        Console.Write("City: ");
        city = Console.ReadLine();

        //Ask for customer's state.
        Console.Write("State: ");
        state = Console.ReadLine();

        //Ask for customer's Zip Code.
        Console.Write("Zip code: ");
        zipCode = Console.ReadLine();

        //Ask customer how many of item.
        Console.Write("How many magic blenders do you want to order? ");
        orderQuantity = Console.ReadLine();
        qty = Convert.ToInt32(orderQuantity);

        //Multiply the price of the item x ordered.
        total = qty * blender;
        plusTax = tax * total;
        due = total + plusTax;

        //Print out the recipe.
        Console.WriteLine("\nReceipt for:");
        Console.WriteLine(name);
        Console.WriteLine(street);
        Console.WriteLine("{0}, {1} {2}\n", city, state, zipCode);
        Console.WriteLine("{0} blenders ordered @{1} each\n", orderQuantity, blender);

        Console.WriteLine("Total:{0}", string.Format("{0, 10}", total.ToString()));
        Console.WriteLine("Tax:{0}", string.Format("{0, 12}", plusTax.ToString()));
        Console.WriteLine("----------------------------");
        Console.Write("Due:{0}", string.Format("{0, 12}",due.ToString()));
    }
}