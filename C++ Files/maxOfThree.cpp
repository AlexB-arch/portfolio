#include <iostream>
using namespace std;

int main()
{
    int first, second, third;

    cout << "This program identifies the largest of three numbers." << endl;
    cout << endl;
    cout << "Enter integer: ";
    cin >> first;
    cout << "Enter integer: ";
    cin >> second;
    cout << "Enter integer: ";
    cin >> third;
    cout << endl;

    if(first > second && first > third)
        cout << "The largest number is " << first << ".";
        else if(second > first && second > third)
            cout << "The largest number is " << second << ".";
           else if(third > first && third > second)
                cout << "The largest number is " << third << ".";

                else
                {
                    if(first == second || first == third)
                    cout << "The largest number is " << first << ".";
                       else if(second == first || second == third)
                        cout << "The largest number is " << second << ".";
                            else if(third == first || third == second)
                                cout << "The largest number is " << third << ".";
                }
}