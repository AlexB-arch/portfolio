#include <iostream>
using namespace std;

//Recommended default date struct.
struct Date {
    int day;
    int month;
    int year;
};

//User inputs desired date here in Month/Day/Year format.
 istream& operator>>(istream& in, Date& currentDate)
{
    char slash;

   in >> currentDate.month >> slash >> currentDate.day >> slash >> currentDate.year;
   return in;
}


ostream& operator<<(ostream& out, Date currentDate)
{
    char slash = '/';
    out << currentDate.month << slash << currentDate.day << slash << currentDate.year;
    return out;
}

Date operator+(Date currentDate, int addDay){

    int totalDays;
    int addMonth = currentDate.month;
    int addYear = currentDate.year;

    //Check for how many days a month has.
    if(addMonth == 1 || addMonth == 3 || addMonth == 5 || addMonth == 7 || addMonth == 8 || addMonth == 10 || addMonth == 12){
        totalDays = 31;
    }
    else if(addMonth == 4 || addMonth == 6 || addMonth == 9 || addMonth == 11){
        totalDays = 30;
    }
    //This line checks for leap years.
    if(addMonth == 2){
	    if((addYear % 400 == 0) || (addYear % 4 == 0 && addYear % 100 != 0)){	
		 totalDays = 29;
        }
		else{	
			totalDays = 28;
        }
	}

    if( currentDate.day + addDay <= totalDays ){
        currentDate.day += addDay;
    }
    else if(currentDate.day + addDay >= totalDays && addMonth < 12){
        currentDate.day = 1;
        currentDate.month += 1;
        //Rolls into the next month if days is greater than totalDays.
    }
    else if(currentDate.month + addDay > 12){
        currentDate.day = 1;
        currentDate.month = 1;
        currentDate.year++;
        //Rolls onto the next year and resets the day and month.
    }
   
    return currentDate;
}

Date getTomorrow(Date currentDate){
    return currentDate + 1;
}

//Overloads "is equal" and validates if two dates are the same.
bool operator==(Date x, Date y){
    if(x.month == y.month && x.day == y.day && x.year == y.year){
        return true;
    }
        else
        {
            return false;
        }      
}
//Overload "Greater than" operator.
bool operator>(Date x, Date y){
    //Assume that its always true unless the condition is met.
    if(x.year < y.year)
        return false;
            if(x.year == y.year && x.month < y.month)
                return false;
                    if(x.year == y.year && x.month == y.month && x.day < y.day)
                        return false;
                            else
                                return true;
    
}
//Overload "Lesser than" operator.
bool operator<(Date x, Date y){
    //Asume that its true unless the condition is met.
    if(x.year > y.year)
        return false;
            if(x.year == y.year && x.month > y.month)
                return false;
                    if(x.year == y.year && x.month == y.month && x.day > y.day)
                        return false;
                            else
                                return true;
    
}
//Overload "Greater or equal to" operator.
bool operator>=(Date x, Date y){
    if(x.year < y.year)
        return false;
            if(x.year == y.year && x.month < y.month)
                return false;
                    if(x.year == y.year && x.month == y.month && x.day < y.day)
                        return false;
                            else
                                return true;
}
//Overload "Lesser or equal to" operator.
bool operator<=(Date x, Date y){
    if(x.year > y.year)
        return false;
            if(x.year == y.year && x.month > y.month)
                return false;
                    if(x.year == y.year && x.month == y.month && x.day > y.day)
                        return false;
                            else
                                return true;
}