#include <iostream>
using namespace std;

int main()
{

    int hours, minutes, seconds;

    cout << "This program converts seconds into hours, minutes and seconds." << endl;
    cout << "Enter the number of seconds: ";
    cin >> seconds;

    minutes = seconds / 60; //Calculates minutes from the input.
    hours = minutes / 60; //Calculates hours from the minutes calculated from the input.
    seconds = seconds % 60; //Displays the remainder of seconds after calculating hours and minutes.
    minutes = minutes % 60; //Displays the remainder of minutes after calculating hours.


    cout << "This corresponds to " << hours << " hours, " << minutes << " minutes, and " << seconds << " seconds.";
}