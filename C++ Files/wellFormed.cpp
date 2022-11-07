#include <iostream>
#include <sstream>
#include <string>
#include "p2stack.h"
using namespace std;

int main(){

    //Define the stack and variables.
    Stack<char> charStack;

    string brackets;

  initialize(charStack);

    //Ask for expression input.
    cout << "Enter expression: ";
    cin >> brackets;

    //Verify if the opening bracket is the right match for the closing bracket.
    bool goodSoFar = true;
    int i = 0;
    while( brackets[i] != 0 && goodSoFar ) // until we reach end of string
    {
        if(brackets[i] == '(' || brackets[i] == '['){
          push(charStack, brackets[i]);
        }
        // otherwise, assume closing bracket
        else if( isEmpty(charStack))
        {
          // what do we do if stack is empty?
          goodSoFar = false;
        }
        // stack has something
        else 
        {
          char recent = pop(charStack);
          if(brackets[i] == ')' && recent != '('){
                
                goodSoFar = false;
              } 
              else if(brackets[i] == ']' && recent != '[') {
              
                goodSoFar = false;
              }
              else{
                goodSoFar = true;
              }
        }
       i++;
          
    }
    if (isEmpty(charStack) && goodSoFar){
                cout << "Expression " << brackets << " is well-formed.";
              }
              else{
                cout << "Expression " << brackets << " is not well-formed.";
              }
   
   destroy(charStack);
}