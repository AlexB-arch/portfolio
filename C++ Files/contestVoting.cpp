#include <iostream>
#include <fstream>
#include <iomanip>
#include "p2queue.h"
#include "p2map.h"
#include "p2priorityqueue.h"
using namespace std;

int main(){

    Queue<string> allContestants;
    Map<string, int> votesSoFar;
    Map<int, int> phoneNumbers;
    PriorityQueue<string, int> ranking;

    string contestants, votedFor, contestantFile, voteFile, nameLookup, rank;
    ifstream fin;
    ofstream fout;
    int votes, phone, alreadyCast, totalContestants;
    float votePercentage, finalContestantVotes, totalVotes, realVoteCount;
    

    initialize(allContestants);
    initialize(phoneNumbers);
    initialize(votesSoFar);
    initialize(ranking);

    cout << "Enter filename containing list of contestants: ";
    cin >> contestantFile;
    cout << "Enter filename containing list of votes: ";
    cin  >> voteFile;

    fin.open(contestantFile.c_str());

    if(fin.is_open()){

        fin >> totalContestants;//Stores the total of contestants to be used later.
            while(fin >> contestants){
                push(allContestants, contestants);
                assign(votesSoFar, contestants, 0);
        }
    }
    fin.close();

    fin.open(voteFile.c_str());
    
    if(fin.is_open()){
        //This section counts votes for all contestants as it reads the file.
        fin >> totalVotes;//Stores the total votes for later use.
            while(fin >> votedFor >> phone){
                // if this is first vote from phone,
                //  add it to the Map showing zero previous votes
               if(!has_key(phoneNumbers, phone)){
                   assign(phoneNumbers, phone, 0);
               }
               // At this point we know phone is in the Map
               if(lookup(phoneNumbers, phone) < 4){
                   assign(phoneNumbers, phone, lookup(phoneNumbers,phone) + 1);
                   assign(votesSoFar, votedFor, lookup(votesSoFar, votedFor) + 1);
                   realVoteCount++;
               }
            }

            while(!isEmpty(allContestants)){
                nameLookup = pop(allContestants);

                if(has_key(votesSoFar, nameLookup)){
                    push(ranking, nameLookup, lookup(votesSoFar, nameLookup));
                }
            }
            cout << "Final rankings" << endl;

            while(!isEmpty(ranking)){
                rank = pop(ranking);

                    if(has_key(votesSoFar, rank)){

                        finalContestantVotes = lookup(votesSoFar, rank);
                        votePercentage = (finalContestantVotes / realVoteCount) * 100;

                        cout << fixed;//Display one digit after the decimal point, regarless of the true result.
                        cout << setprecision(1);
                        cout << votePercentage << "% " << rank << endl;
                    }
            }

    }
    fin.close();

    destroy(allContestants);
    destroy(phoneNumbers);
    destroy(votesSoFar);
    destroy(ranking);
}