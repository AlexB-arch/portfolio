#include <iostream>
#include <fstream>
#include <string>
#include "p2priorityqueue.h"
using namespace std;

int main(){

    PriorityQueue<int,int> pq332;
    PriorityQueue<int,int> pq352;
    PriorityQueue<int,int> pq365;

    

initialize(pq332);

    ifstream fin;
    ofstream fout;
    string filename, courseNumber;
    int count, studentID, semesters;
    //Enter filename in order to retrieve the student data.
    cout << "Enter filename: ";
    cin >> filename;

    //Open the desired file.
    fin.open(filename.c_str());

    //Read the file as console input.
    if(fin.is_open()){
        while (fin >> courseNumber >> studentID >> semesters){
            int key = semesters;
            int value = studentID;
            push(pq332,semesters, studentID);
            //cout << pq332.top() << " " << pq352.top() << " " << pq365.top() << endl;
        }



    }
    else{
        cout << "File not found." << endl;
    }
    
    //Create 3 new files named CS332, CS352, and CS365.
    fout.open("CS332");
    fout.open("CS352");
    fout.open("CS365");

        while(fout.is_open() && != isEmpty(pq332)) ){
            fout << pop(pq332, studentID);

        }
        else{
            cout << "Files not found." << endl;
        }
    fout.close();

    fin.close();

    destroy(pq332);

    //Sort students by who has been in school more semesters.

    //If file fails to open, notify the user.
    
    
}