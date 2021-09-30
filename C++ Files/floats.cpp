#include <iostream>
using namespace std;

int main()
{
    // Create three float variables: x, y, sum
    float x;
    float y;
    float sum;

    cout << "This program adds two numbers." << endl;

    // Prompt the user to enter their 1st number, read the input value into variable x
    cout << "1st number? ";
    cin >> x;

    // Prompt the user to enter their 2nd number, read the input value into variable y
    cout << "2nd number? ";
    cin >> y;

    // Add x and y, store the answer in variable sum
    sum = x+y;

    // Output the result, e.g., if x = 3 and y = 4, your program should print "The total is 7."
    cout << "The total is " << sum << "." << endl;
}