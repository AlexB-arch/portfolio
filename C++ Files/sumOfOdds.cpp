#include <iostream>
using namespace std;

int main(){

    int num;

    cout<<"Enter a number: ";
    cin>>num;

    int sum = num;
    
    while(num>=0){
        if(num%2==1){
            sum = sum + num;
        }
       num--; 
    }
    cout << "The sum of the odd numbers is " << sum << ".";
}