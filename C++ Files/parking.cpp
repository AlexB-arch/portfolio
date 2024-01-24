#include <iostream>
using namespace std;

int main(){

    int minutes;
    float cost = 0;

    cout << "Enter parking duration (in minutes): ";
    cin >> minutes;

    switch (minutes)
    {
        case 0 ... 30:
            cost = 0;
            break;

        case 31 ... 60:
            cost = 2;
            break;

        case 90 ... 120:
            cost = 4;
            break;

        case 121 ... 150:
            cost = 5;
            break;

        case 151 ... 180:    
            cost = 6;
            break;

        case 181 ... 210:
            cost = 7;
            break;

        case 211 ... 240:    
            cost = 8;
            break;
        
        case 241 ... 270:
            cost = 9;
            break;

        case 271 ... 300:
            cost = 10;
            break;

        case 301 ... 330:    
            cost = 11;
            break;

        case 331 ... 360:    
            cost = 12;
            break;

        case 361 ... 390:
            cost = 13;
            break;

        case 391 ... 420:
            cost = 14;
            break;

        default:
            cost = 25;
            break;
    }

    cout << "Parking Cost: $" << cost << endl;
}