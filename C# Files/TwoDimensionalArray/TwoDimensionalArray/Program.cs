using System;

namespace TwoDimensionalArray
{
    class Program
    {
        static void Main(string[] args)
        {
            //ONE DIMENSIONAL ARRAY EXAMPLES.
            //Array with specific size.
            int[] array1 = new int[5] { 1, 2, 3, 4, 5 };
            //Array size determined by it's initiated contents.
            int[] array2 = new int[] { 1, 2, 3, 4, 5 };
            int[] array3 = { 1, 2, 3, 4, 5 };
            //They are all the same, but initialized differenty.

            //TWO-DIMENSIONAL ARRAY - RECTANGULAR EXAMPLES.
            //3x3 Array by directly inserting values.
            int[,] sales1 = { { 100, 435, 583 },
                             { 100, 435, 583 },
                             { 100, 435, 583 } };
            //3x3 array like above, but empty.
            int[,] sales2 = new int[3, 3];

            for(int i = 0; i < sales1.GetLength(0); i++)
            {
                for(int j = 0; j < sales1.GetLength(1); j++)
                {
                    Console.WriteLine(sales1[i, j]);
                }
            }

            //JAGGED ARRAY - Composed of arrays of various sizes.

            //SORTING
            int[] sortedArray = { 12, 6, 9, 34, 2 };
            Array.Sort(sortedArray);
            for (int j = 0; j < sortedArray.GetLength(0); j++)
                Console.Write("{0} ", sortedArray[j]);

            //REVERSE
            int[] reversedArray = { 12, 6, 9, 34, 2 };
            Array.Reverse(reversedArray);
            for (int j = 0; j < reversedArray.GetLength(0); j++)
                Console.Write("{0} ", reversedArray[j]);
        }
    }
}
