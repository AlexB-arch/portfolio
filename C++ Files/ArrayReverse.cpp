#include <iostream>
using namespace std;

//Function that reverses an array.
int reverseArray(int a[]) {

    int temp = 0, start = 0, end = a.size()-1;
    
    while(start < end){
        int temp = a[start]; 
        a[start] = a[end];
        a[end] = temp;
        start++;
        end--;
    }  
    return a;
}

int main(){
    int someInts = [1,2,3,4];

    cout << "Array [1,2,3,4] reversed: " << reverseArray(someInts);
}