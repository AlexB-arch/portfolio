#include <iostream>
using namespace std;

int main ()
{
    float base;
    float height;
    float area;

    cout << "This program computes the area of a triangle." << endl;
    cout << endl;
    //Prompt user for input of two numbers
    cout << "Enter the base of the triangle: ";
    cin >> base;

    cout << "Enter the height of the triangle: ";
    cin >> height;
    cout << endl;
//Gives the area of the triangle
    area = (base*height)/2;
    cout << "The area is " << area << endl;
}