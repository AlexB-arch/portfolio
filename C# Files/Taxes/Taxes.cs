using System;

    class Program
    {
        static void Main(string[] args)
        {
        //Variables to store needed data.
        string name, ssn, hourlyRate, hoursWorked;
        const double fedTaxRate = 0.15, stateTaxRate = 0.05;
        double grossPay,hours, rate, netPay, fedWithheld, stateWithheld;

        //Prompts the user for input.
        Console.Write("Enter your name: ");
        name = Console.ReadLine();

        Console.Write("Social Security number: ");
        ssn = Console.ReadLine();

        //Convert string to decimal as soon as you have input.
        Console.Write("Hourly pay rate: ");
        hourlyRate = Console.ReadLine();
        rate = Convert.ToDouble(hourlyRate);

        Console.Write("Hours worked: ");
        hoursWorked = Console.ReadLine();
        hours = Convert.ToDouble(hoursWorked);

        //Output.
        Console.WriteLine("\nPayroll Summary for: {0}", name);
        Console.WriteLine("SSN: {0}", ssn);
        Console.WriteLine("You earned {0} hours at {1} per hour\n", hoursWorked, hourlyRate);

        /*Calculate tax withholdings, then output
        without currency sign, rounded to two decimal places.
        Each output must occupy 10 spaces.*/
        grossPay = hours * rate;
        Console.WriteLine("Gross pay:{0}", String.Format("{0,21}", grossPay.ToString("F2")));

        fedWithheld = grossPay * fedTaxRate;
        Console.WriteLine("Federal withholding:{0}", String.Format("{0,11}", fedWithheld.ToString("F2")));
        stateWithheld = grossPay * stateTaxRate;
        Console.WriteLine("State withholding:{0}", String.Format("{0,13}", stateWithheld.ToString("F2")));
        Console.WriteLine("----------------------------------");

        netPay = (grossPay - fedWithheld) - stateWithheld;
        Console.Write("Net pay:{0}", String.Format("{0,23}", netPay.ToString("F2")));
        }
    }