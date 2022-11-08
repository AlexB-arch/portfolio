using System;

class Program
{
    static void Main(string[] args)
    {
        //Defines variables to be used.
         
        int inputOne, inputTwo;
        char symbol;

        //Prompts to be printed on the console.
        Console.WriteLine("Basic Calculator Program");

        //Prompts and accepts input from the user and converts string to integer.
        Console.Write("Enter the first integer: ");
        inputOne = Convert.ToInt32(Console.ReadLine());

        //Prompts and accepts input from the user and converts string to integer.
        Console.Write("Enter the second integer: ");
        inputTwo = Convert.ToInt32(Console.ReadLine());

        //Prompts and accepts input from the user and converts string to char.
        Console.Write("Enter the operator: ");
        symbol = Convert.ToChar(Console.ReadLine());

        switch (symbol)
        {
            case '+':
                Console.Write("The result is: {0}", inputOne + inputTwo);
                break;

            case '-':
                Console.Write("The result is: {0}", inputOne - inputTwo);
                break;

            case '*':
                Console.Write("The result is: {0}", inputOne * inputTwo);
                break;

            case '/':
                //Checks if user tries to divide by 0 and prints Error if true.
                if (inputTwo == 0)
                {
                    Console.Write("Error: cannot divide by zero.");
                    break;
                }

                else
                Console.Write("The result is: {0}", inputOne / inputTwo);
                break;

            //Any other case will default to here.
            default:
                Console.Write("Invalid operation.");
                break;
        }
    }
}

