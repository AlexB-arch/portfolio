#include <iostream>
using namespace std;

int main()
{
//Pool dimensions in feet.
    int length, width, depth;
    
//Rate of gallons water per minute.
    int rate;

//Prompts the user to enter the pool dimensions.
cout << "Enter pool dimensions" << endl;
cout << "Length: ";
cin >> length;

cout << "Width: ";
cin >> width;

cout << "Depth: ";
cin >> depth;
cout << endl;

//Ask the user the rate of water flowing into the pool.
cout << "Water entry rate: ";
cin >> rate;
cout << endl;

//Calculates the time it will take to fill the pool according to the measure and rate of water.
cout << "The pool will fill completely in " << length * width * depth * 7.48 / rate << " minutes" << endl;

}
