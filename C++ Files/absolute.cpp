#include <iostream>
using namespace std;

int main()
{
    int value, absolute;

    cout << "Enter integer: ";
    cin >> value;
    absolute = abs(value);//Converts input into absolute value.

    cout << "|" << value << "| = " << absolute;   
}