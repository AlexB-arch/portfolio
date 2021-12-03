#include <iostream>
using namespace std;

int main(){

    int month, day, year;
    int monthTwo, dayTwo, yearTwo;

    cout << "Enter date #1 (month day year): ";
    cin >> month;
    cin >> day;
    cin >> year;
    cout << "Enter date #2 (month day year): ";
    cin >> monthTwo;
    cin >> dayTwo;
    cin >> yearTwo;

if(year < yearTwo){
     if(year == yearTwo && month < monthTwo)
         cout <<month<<"/"<<day<<"/"<<year<< " is earlier.";
             if(year == yearTwo && month == monthTwo && day < dayTwo)
                cout <<month<<"/"<<day<<"/"<<year<< " is earlier.";
                    else
                        cout <<month<<"/"<<day<<"/"<<year<< " is earlier.";           
    }
 if(yearTwo < year){
     if(yearTwo == year && monthTwo < month)
        cout <<monthTwo<<"/"<<dayTwo<<"/"<<yearTwo<< " is earlier.";
            if(yearTwo == year && monthTwo == month && dayTwo < day)
                cout <<monthTwo<<"/"<<dayTwo<<"/"<<yearTwo<< " is earlier.";
                else
                    cout <<monthTwo<<"/"<<dayTwo<<"/"<<yearTwo<< " is earlier.";       
    }
else if(year == yearTwo || yearTwo == year){
    if((month == monthTwo && day <= dayTwo)||(day == dayTwo && month < monthTwo))
        cout <<month<<"/"<<day<<"/"<<year<< " is earlier.";
            if((monthTwo == month && dayTwo < day)||(dayTwo == day && monthTwo < month))
                cout <<monthTwo<<"/"<<dayTwo<<"/"<<yearTwo<< " is earlier.";
                if((month < monthTwo)||(day < dayTwo)||(month < monthTwo && day > dayTwo))
                    cout <<month<<"/"<<day<<"/"<<year<< " is earlier.";
                    else if((monthTwo < month)||(dayTwo < day))
                        cout <<monthTwo<<"/"<<dayTwo<<"/"<<yearTwo<< " is earlier.";        
    }



}
