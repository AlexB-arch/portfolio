#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    int quantity;
    float quarter, dime, nickel, pennie;
    float total;

    cout << "Quarters: ";
    cin >> quantity;
    quarter = .25 * quantity;

    cout << "Dimes: ";
    cin >> quantity;
    dime = .10 * quantity;

    cout << "Nickels: ";
    cin >> quantity;
    nickel = .05 * quantity;

    cout << "Pennies: ";
    cin >> quantity;
    pennie = .01 * quantity;

    total = quarter + dime + nickel + pennie;

    cout << endl;

    cout << fixed;
    cout << setprecision(2); 
    cout << "The total is $" << total;

}