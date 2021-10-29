#include <iostream>
#include <fstream>
#include "p2queue2.h"
using namespace std;

template <typename T>
bool operator==(T num, T letter){
    if(num != letter)
        return false;

    return true;
}

int draw(int card, Queue<int>& hand){

    if(card == 'A'){
       return 14;
                
    }

    if(card == 'K'){
        return 13;  
    }

    if(card == 'Q'){
        return 12;
    }

    if(card == 'J'){
        return 11;
    }

    return card;
}


int main(){

    Queue<int> pileOne, pileTwo, handOne, handTwo;
    int round, onePlayed, twoPlayed, scoreOne, scoreTwo;
    ifstream fin;
    char card;


    initialize(pileOne);
    initialize(handOne);
    initialize(pileTwo);
    initialize(handTwo);

    fin.open("player1");
    if(fin.is_open()){
        while(fin >> card){
            draw(card, handOne);
        }
    }

    fin.close();

    fin.open("player2");
    if(fin.is_open()){
        while(fin >> card){
            draw(card, handTwo);
        }
    }

    fin.close();

    while(!isEmpty(handOne) || !isEmpty(handTwo)){
        onePlayed = pop(handOne);
        twoPlayed = pop(handTwo);

        if(onePlayed > twoPlayed){
            push(pileOne, onePlayed);
            push(pileOne, twoPlayed);
            scoreOne++;
        }

        if(onePlayed < twoPlayed){
            push(pileTwo, twoPlayed);
            push(pileTwo, onePlayed);
            scoreTwo++;
        }

        if(onePlayed == twoPlayed){
            for(int i = 0; i < 3; i++){
                onePlayed = pop(handOne);
                twoPlayed = pop(handTwo);
            }
        }
        round++;
    }
    
    if(round == 5000){
        cout << "Nobody wins.";
    }

    if(scoreOne < scoreTwo)
        cout << "Player #2 wins after " << round << " battles.";
    
    if(scoreOne > scoreTwo)
        cout << "Player #1 wins after " << round << " battles.";

    destroy(pileOne);
    destroy(handOne);
    destroy(pileTwo);
    destroy(handTwo);
}