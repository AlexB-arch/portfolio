#include <iostream>
using namespace std;

int main()
{
    float value;
    int rounded;

    cout << "Enter a number: ";
    cin >> value;
    
    rounded = value; //Typecast value as an integer.
    value = value - rounded; //Substracts the value before the decimal point, the remainder serves as the condition for the if statements
 
    if(value > 0 && value <= .4)
    {
      cout << "The rounded number is " << rounded;
    }

    if(value > 0 && value >=.5)
    {
      rounded++;
      cout << "The rounded number is " << rounded;
    }

    if(value <= 0 && value >= -0.4)
    {
      cout << "The rounded number is " << rounded;
    }
    else if(value <= 0 && value <= -0.5)
    {
      rounded--;
      cout << "The rounded number is " << rounded;
    }
    else
      cout << "The rounded number is " << rounded;
         
}