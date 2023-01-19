#include <iostream>
#include <fstream>
#include "p2map.h"
using namespace std;

string findOldest(Map<string, string>& mapSons, string name){
    while(has_key(mapSons, name)){
        name = lookup(mapSons, name);

        if(!has_key(mapSons, name))
            break;
    }

    return name;
}

int main(){

    Map<string, string> father_son;
    Map<string, string> son_father;
    string key, value, filename, firstFather;
    ifstream fin;
    ofstream fout;

    initialize(father_son);
    initialize(son_father);

    cout << "Input file: ";
    cin >> filename;

    string fixed = "fixed_" + filename;

    fin.open(filename.c_str());
    fout.open(fixed.c_str());

    if(fin.is_open()){
        //This loop populates the maps.
        while(fin >> key >> value){
            //checks for first father every iteration.
           firstFather = findOldest(son_father, key);
            //Validate pairs according to their key to find their respective parent.
            assign(son_father, value,  key);
            assign(father_son, key, value);
        }
        //firstFather becomes the key in which to start looking through the maps.
        key = firstFather;
        if(has_key(father_son, key))
            value = lookup(father_son, key);

        //After output, the last value will become the next key.
        while(has_key(father_son, key)){
            fout << key << " " << value << endl;
            key = value;

            if(has_key(father_son, key)){
                value = lookup(father_son, key);
            }

            else if(!has_key(father_son, key)){
                break;
            }
        }    
        
    }
    cout << endl;
    cout << "Ordering complete.";

    fin.close();
    fout.close();

    destroy(father_son);
    destroy(son_father);
}



