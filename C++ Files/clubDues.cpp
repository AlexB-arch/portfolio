#include <iostream>
#include <fstream>
#include <string>
#include "p2map.h"
using namespace std;

int memberFilter(Map<string, string>& members, string member){
    int fee = 0;
    int discount = 18;

    if(!has_key(members, member)){
        fee = fee + 80;
    }
    
    if(has_key(members, member))
        fee = 80 - discount;

    return fee;
}

int main(){

    Map<string, string> oldMembers, newMembers;
    ifstream fin;
    ofstream fout;
    string member, file;
    int currentMemFee = 0, newMemFee = 0, unique = 0;

    initialize(oldMembers);
    initialize(newMembers);

    fin.open("8A_past.txt");
    if(fin.is_open()){
        getline(fin, member);
        while(getline(fin, member)){
            if(!has_key(oldMembers, member)){
                currentMemFee = memberFilter(newMembers, member);
                unique++;
            }
            assign(oldMembers, member, member);
            //cout << member << endl;
        } 
    }
    fin.close();

    fin.open("8A_new.txt");
    if(fin.is_open()){
        getline(fin, member);
            while(getline(fin, member)){
                assign(newMembers, member, member);

                if(!has_key(oldMembers, member)){
                    unique++;
                }
                //cout << member << endl;
            }
    }
    fin.close();

    
    cout << "Old Member Dues: $" << currentMemFee << endl;
    cout << "New Member Dues: $" << newMemFee << endl;
    cout << "Total expected:  $" << currentMemFee + newMemFee << endl;
    cout << endl;
    cout << "Two-year membership: " << unique;

    destroy(oldMembers);
    destroy(newMembers);
}