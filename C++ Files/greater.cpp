#include <iostream>
using namespace std;

int main ()
{
    int first, second;

    cout << "This program determines the relationship between two input numbers." << endl;
    cout << "Enter the first integer: ";
    cin >> first;

    cout << "Enter the second integer: ";
    cin >> second;

    if(first > second)
    
        cout << first << " is greater than " << second;

    if(first < second)
    
            cout << first << " is less than " << second;
    
            
    
    else if (first == second)
    
        cout << first << " is equal to " << second;
    
}