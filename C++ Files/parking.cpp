#include <iostream>
using namespace std;

int main(){

    int minutes;
    float cost = 0;

    cout << "Enter parking duration (in minutes): ";
    cin >> minutes;

    if(minutes <= 30){
        cout << "Parking cost = $" << cost;
    }
    if(minutes >= 31 && minutes <= 60){
        cout << "Parking cost = $" << cost + 2;
    }
    if(minutes > 60){
        if(minutes >= 90 && minutes <= 120)
        cout << "Parking cost = $" << cost + 4;
            if(minutes >= 121 && minutes <= 150)
            cout << "Parking cost = $" << cost + 5;
                if(minutes >= 151 && minutes <= 180)
                cout << "Parking cost = $" << cost + 6;
                    if(minutes >= 181 && minutes <= 210)
                    cout << "Parking cost = $" << cost + 7;
                        if(minutes >= 211 && minutes <=240)
                        cout << "Parking cost = $" << cost + 8;
                            if(minutes >= 241 && minutes <= 270)
                            cout << "Parking cost = $" << cost + 9;
                                if(minutes >=271 && minutes <= 300)
                                cout << "Parking cost = $" << cost + 10;
                                    if(minutes >= 301 && minutes <= 330)
                                    cout << "Parking cost = $" << cost + 11;
                                        if(minutes >= 331 && minutes <= 360)
                                        cout << "Parking cost = $" << cost + 12;
                                            if(minutes >= 361 && minutes <= 390)
                                            cout << "Parking cost = $" << cost + 13;
                                                if(minutes >= 391 && minutes <= 420)
                                                cout << "Parking cost = $" << cost + 14;
                                                    else
                                                    cout << "Parking cost = $" << cost + 3;
    }
    if(minutes > 420){
        if(minutes>420&&minutes<=480)
        cout << "Parking cost = $" << cost + 15;
            if(minutes>=481&&minutes<=540)
            cout << "Parking cost = $" << cost + 16;
                if(minutes>=541&&minutes<=600)
                cout << "Parking cost = $" << cost + 17;
                    if(minutes>=601&&minutes<=660)
                    cout << "Parking cost = $" << cost + 18;
                        if(minutes>=661&&minutes<=720)
                        cout << "Parking cost = $" << cost + 19;
                            if(minutes>=721&&minutes<=780)
                            cout << "Parking cost = $" << cost + 20;
                                else
                                cout << "Parking cost = $" << cost + 21;

    }

}