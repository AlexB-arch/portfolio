#include <iostream>
#include <sstream>
#include <cmath>
using namespace std;


int main(){

    int count, recount, result, N[50], difference[50];
    string data;
    bool checkSequence = false;

//Asks for a list of numbers and automatically passes it onto a stringstream.
cout << "Enter list: ";
getline(cin,data);
stringstream sequence(data);


//Scan the stream for numbers. Passes them to N.
    count = 0;
    while( sequence >> N[count] )
        count++;  
    // now all values in array and count is how many there are

    // now loop through all values, finding the differences
    for( int i = 0; i < count-1; i++ ){
        result = abs(N[i] - N[i+1]);
        difference[i] = result;
    }
    for( int j = 0; j < count; j++){
        checkSequence = false; 
        for( int i = 0; i < count; i++){

            if(difference[i] == j){
                checkSequence = true;
            }          
        }
        if (checkSequence == false){
           recount = j;
           break;
        }
    }
    if(checkSequence == false){
        cout << "Bad sequence: missing " << recount << "." << endl;
    }
    else{
        cout << "Good sequence." << endl;
    }
}