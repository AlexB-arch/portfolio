#include <iostream>
#include <fstream>
#include "p2priorityqueue.h"
#include "p2queue2.h"
#include "p2set.h"
using namespace std;

int main(){

    PriorityQueue<string, int> cat;
    PriorityQueue<string, int> dog;
    Queue<string> either;
    Set<string> adopted;

    ifstream fin;
    ofstream fout;
    string command, petType, petName, cats, dogs, catsORdogs;

    initialize(cat);
    initialize(dog);
    initialize(either);
    initialize(adopted);

    fin.open("actions.txt");
    fout.open("adoptions.txt");

    if(fin.is_open()){

    while(fin >> command >> petType){

        if(command == "rescue"){
            if(petType == "cat"){
                    
                    fin >> petName;
                    push(cat, petName, 1);
                    push(either, petName);
                }
                if(petType == "dog"){
                
                    fin >> petName;
                    push(dog, petName, 1);
                    push(either, petName);
                }
        } 
            if(command == "request"){
                    
                if(petType == "cat" && !isEmpty(cat)){
                    cats = pop(cat);
                    if(contains(adopted, cats)){
                        cats = pop(cat);
                        fout << cats << endl;
                        insert(adopted, cats);
                        }
                    else{
                        fout << cats << endl;
                        insert(adopted, cats);
                    }
                }
                
                if(petType == "dog" && !isEmpty(dog)){
                    dogs = pop(dog);
                    if(contains(adopted, dogs)){
                        dogs = pop(dog);
                        fout << dogs << endl;
                        insert(adopted, dogs);
                    }
                    else{
                        fout << dogs << endl;
                        insert(adopted, dogs);
                        }
                    
                }
            
                if(petType == "either" && !isEmpty(either)){

                    catsORdogs = pop(either);

                    while(contains(adopted, catsORdogs) && !isEmpty(either)){
                        catsORdogs = pop(either);
                            if (!isEmpty(cat)){
                                cats = pop(cat);
                                if (catsORdogs == cats){
                                    fout << cats << endl;
                                    insert(adopted, cats);
                                    }
                                else{
                                    push(cat, cats, 2);
                                    }
                                }
                            if(!isEmpty(dog)){
                                dogs = pop(dog);
                                if(catsORdogs == dogs){
                                    fout << dogs << endl;
                                    insert(adopted, dogs);
                                    }
                                else{
                                    push(dog, dogs, 2);
                                    }
                                }
                            break;
                            }
                        if(!contains(adopted, catsORdogs)){
                            fout << catsORdogs << endl;
                            insert(adopted, catsORdogs);
                            }
                    }
                } 
            }          
        } 
    
    fin.close();
    fout.close();

    destroy(cat);
    destroy(dog);
    destroy(either);
    destroy(adopted);
}