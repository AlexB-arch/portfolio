#include <iostream>
using namespace std;

int main(){

    int month, year;

    cout << "Month: ";
    cin >> month;
    cout << "Year: ";
    cin >> year;
    cout << endl;

if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
    cout << month << "/" << year << " has 31 days."; 
    }
    else if(month == 4 || month == 6 || month== 9 || month == 11){
        cout << month << "/" << year << " has 30 days.";
    }
if(month == 2){
	if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))	
		cout << month << "/" << year << " has 29 days.";
		else	
			cout << month << "/" << year << " has 28 days.";
	}
    
}