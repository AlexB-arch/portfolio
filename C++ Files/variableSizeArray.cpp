#include <iostream>
using namespace std;

int main() {
    int a, b;
    
    cin >> a;

    //Declare the array after a has been defined.
    int nums[a];
    
    //First, populate the array.
    for(int i = 0;i < a;i++){
        cin >> b;
        nums[i] = b;  
    }

    //Then, output the array starting from the last index spot.
    while(a > 0){
        cout << nums[a-1] << " ";
        a--;
    } 
}