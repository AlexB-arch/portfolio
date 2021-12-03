#include <iostream>
#include <sstream>
using namespace std;

int cakeBuild(int cakes[], int height, int index){

        if(cakes[index+1] > cakes[index]){
            return cakeBuild(cakes, height, index+1);
        }
            
        return cakeBuild(cakes, height+1, index+1); 
} 

int main(){

    int next = 0, index = 0, height = 0, cakes[30], layer;
    string input;

    cout << "Cake sizes: ";
    getline(cin, input);
    stringstream stream(input);

    while(stream >> layer){
        cakes[next++] = layer;
    }

    cakeBuild(cakes, height, index);

    cout << "You can build a cake with " << height << " layers.";
}