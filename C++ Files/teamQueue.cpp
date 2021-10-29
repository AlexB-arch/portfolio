#include <iostream>
#include <fstream>
#include <sstream>
#include "p2set.h"
using namespace std;

string sameTeam(Set<string> teams[], string name){
    string yes;
    for(int i = 0; i < 10; i++){
        if(contains(teams[i], name)){
            yes = name;
        }
    }

    return yes;
}

int main(){

   Set<string> teams[10];
   ifstream fin;
   ofstream fout;
   string names, individual;
   stringstream ss(names);
   int teamCount, totalTeams;

    initialize(teams);

   fin.open("teams");
   fout.open("grouped");

   if(fin.is_open()){
       //Grab the total number of teams in the file
       fin >> totalTeams;
       //Read a whole line 
       while(getline(fin, names)){
           //Then extract the names of a team individually to input in the set.
           while(ss >> individual){
               teams[teamCount] = insert(teams, individual);
           }
        teamCount++;
       }       
    }
   cout << "Enter names in order of arrival: " << endl;
   cin >> names;
   while(names != "END"){
       //Check if a name is in the same team and send to file if so.
       fout << sameTeam(teams, names) << endl;
       cin >> names;

       
   }

   fin.close();
   fout.close();

   destroy(teams);  
}