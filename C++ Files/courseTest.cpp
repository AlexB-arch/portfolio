#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <queue>
//#include "p2priorityqueue.h"
using namespace std;

int main(){

    priority_queue<pair<int, int> >  pq332;
    //priority_queue<pair<int, int> > pq352;
    //priority_queue<pair<int, int> > pq365;

    

//initialize(pq332);

    ifstream fin;
    ofstream fout;
    string filename, courseNumber;
    int size, studentID, semesters;
    //Enter filename in order to retrieve the sudent data.
    cout << "Enter filename: ";
    cin >> filename;

    //Open the desired file.
    fin.open(filename);

    //Read the file as console input.

    if(fin.is_open()){
        while (fin >> courseNumber >> studentID >> semesters){
            pq332.push(semesters, studentID);
            cout << pq332.top() << endl;
        }



    }
    else{
        cout << "File not found." << endl;
    }
    
    //Create 3 new files named CS332, CS352, and CS365.
    fout.open("CS332");
    fout.open("CS352");
    fout.open("CS365");


    fout.close();
    fin.close();

    //destroy(pq332);

    //Sort students by who has been in school more semesters.

    //If file fails to open, notify the user.
    
    
}