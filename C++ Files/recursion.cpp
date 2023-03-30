// Calculate factorial
#include <iostream>
using namespace std;

int factorial(int n)
{
   if( n == 0 ) // Base case
      return 1;
 
   return n * factorial(n-1); // recursive call
}

int main( )
{
   int number;
   cout << "Enter number: ";
   cin >> number;

   cout << number << "! = " << factorial(number) << endl;
}