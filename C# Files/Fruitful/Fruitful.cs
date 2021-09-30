using System;

class Program
{
    static void Main(string[] args)
    {
        double[][] A, B, C;
        string userInput;
        int rowA, colA, rowB, colB;
        double sum;
       
        //Ask the user for the size of the first matrix.
        //Create the matrix afterwards.
        Console.Write("How many rows does the first matix have? ");
        rowA = Convert.ToInt32(Console.ReadLine());
        Console.Write("How many columns does the first matrix have? ");
        colA = Convert.ToInt32(Console.ReadLine());

        A = new double[rowA][];
        C = new double[rowA][];

        for (int c = 0; c < A.Length; c++)
            A[c] = new double[colA];

        //Ask the user for the size of the second matrix.
        //Create the matrix afterwards.
        Console.Write("How many rows does the second matix have? ");
        rowB = Convert.ToInt32(Console.ReadLine());
        B = new double[rowB][];

        Console.Write("How many columns does the second matrix have? ");
        colB = Convert.ToInt32(Console.ReadLine());

        for (int c = 0; c < B.Length; c++)
            B[c] = new double[colB];

        //If the columns of array One are not the same as the rows
        //in array Two, it cannot be multiplied.
        if (colA != rowB)
            Console.WriteLine("These two matrices cannot be multiplied.");

        //Now populate the matrices with any desired numbers.
        //Use "index" to indicate what space in the array we're filling.
        else
        {
            for (int i = 0; i < A.GetLength(0); i++)
            {
                Console.Write("Enter a row of the first matrix, separated by spaces: ");
                userInput = Console.ReadLine();
                string[] nums = userInput.Split(" ");
                for (int k = 0; k < nums.Length; k++)
                {

                    A[i][k] = Convert.ToDouble(nums[k]);
                }
            }
            for (int i = 0; i < B.GetLength(0); i++)
            {
                Console.Write("Enter a row of the second matrix, separated by spaces: ");
                userInput = Console.ReadLine();
                string[] nums = userInput.Split(" ");
                for (int k = 0; k < nums.Length; k++)
                {
                    B[i][k] = Convert.ToDouble(nums[k]);
                }
            }

            //Now, we iterate through both matrices to populate the third matrix.
            for (int i = 0; i < rowA; i++)
            { 
                sum = 0;
                C[i] = new double[colB];
                for (int j = 0; j < colB; j++)
                {
                    for (int k = 0; k < colA; k++)
                    {
                        sum += A[i][k] * B[k][j];
                    }
                    //Assign te result to C and reset sum back to 0.
                    C[i][j] = sum;
                    sum = 0;
                }
            }

            //Display all the results inside all the arrays.
            Console.WriteLine("The resulting matrix is: ");
            for (int i = 0; i < C.GetLength(0); i++)
            {
                foreach (double num in C[i])
                {
                    Console.Write("{0, 8}", num.ToString("F2"));
                }
                Console.WriteLine();
            }
        }
    }
}