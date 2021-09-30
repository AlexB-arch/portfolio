using System;

class Program
{
    //Find the mean by dividing the sum of all values divided by the number of values in array.
    public static double Mean(double[] array, int numbers)
    {
        double sum = 0;

        for(int i = 0; i < numbers; i++)
        {
            sum = sum + array[i];
        }

        return sum / numbers;        
    }
    public static double StandardDeviation(double[] array, int numberofelementsinarray)
    {
        double mean = Mean(array, numberofelementsinarray);
        
        //Sustract the mean from each value in the array, then square the result.
        for(int i = 0; i < array.Length; i++)
        {
            array[i] = Math.Pow(array[i] - mean, 2);  
        }
        //Now, find the square root by sending it back to Mean().
        return Math.Sqrt(Mean(array,numberofelementsinarray));
    }

    static void Main(string[] args)
    {
        int N, count = 0;
        double[] values;

        //Ask the user how mamny numbers they'll input.
        Console.Write("How many numbers? ");
        N = Convert.ToInt32(Console.ReadLine());

        //Create array of size N.
        values = new double[N];

        Console.WriteLine("Enter {0} numbers:", N);
        while (count < N)
        {
            values[count] = Convert.ToDouble(Console.ReadLine());
            count++;
        }
        Console.Write("\nStandard Deviation: {0}", StandardDeviation(values, N).ToString("F3"));
    }
}