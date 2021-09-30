using System;

public class Memoization
{
	public static int[] memo;

	public static int fib(int x)
	{
		//Base case to stop the recursion.
		if (x == 1 || x == 2) return 1;

		//If the value of fib is already in the array, return it.
        else if(memo[x-1]!=0)
        {
			return memo[x-1];
        }
        //Else, run the recursion and store new values.
        else
        {
            memo[x-1] = fib(x - 1) + fib(x - 2);
		}
		return memo[x-1];
	}

	
	public static void Main(string[] args)
	{
	
		Console.Write("Please enter the value of n: ");
		int n = Convert.ToInt32(Console.ReadLine());

		//memo is initiated here based on user input, but is avaialble globally.
		memo = new int[n];
		Console.WriteLine("The {0}th Fibonacci number is {1}", n, fib(n));
	}
}