using System;

class Program
{
    static void Main(string[] args)
    {
        int[][] jagged;
        string[] nums;
        string userInput;
        int row, col;

        Console.Write("How many rows does the jagged array have? ");
        row = Convert.ToInt32(Console.ReadLine());
        jagged = new int[row][];
       
        for (int i = 0; i < jagged.Length; i++)
        {
            Console.Write("Enter a row, separated by spaces: ");
            userInput = Console.ReadLine();

            //Splits user input to set column size according to user input
            //length and inserts into array.
            nums = userInput.Split(" ");
            col = nums.Length;
            jagged[i] = new int[col];

            for (int j = 0; j < jagged[i].Length; j++)
            {
                jagged[i][j] = Convert.ToInt32(nums[j]);
                jagged[i][j] = jagged[i][j] * (i + j + 1);
            }
        }

        Console.WriteLine("After the funky operation, the resulting array is:");
        for(int a = 0; a<jagged.Length; a++)
        {
            foreach(int b in jagged[a])
            {
                Console.Write("{0,5}", b.ToString());
                
            }
            Console.WriteLine();
        }
    }
}
