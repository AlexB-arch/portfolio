/ Include iostream to get access to istream, ostream
#include <iostream>
using namespace std;

struct Fraction {
   int num;
   int den;
};

// A function to calculate the greatest common divisor will be useful
int gcd(int a, int b)
{
	if( b == 0 )
		return a;
	return gcd(b,a%b);
}

// All fraction values are reduced
// For example, we have 3/4 and never 9/12
// It would be good to create a function to do that
void reduce(Fraction &f)
{
	
}

istream& operator>>(istream& in, Fraction &f)
{
    // Implement fraction input here
}

ostream& operator<<(ostream& out, Fraction f)
{
    // Implement fraction output here
}

Fraction operator+(Fraction a, Fraction b)
{
    // Implement fraction addition here
}

Fraction operator-(Fraction a, Fraction b)
{
    // Implement fraction subtraction (a-b) here
}

Fraction operator*(Fraction a, Fraction b)
{
    // Implement fraction multiplication here
}

Fraction operator/(Fraction a, Fraction b)
{
    // Implement fraction division (a/b) here
}