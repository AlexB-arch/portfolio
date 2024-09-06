#include <iostream>
#include "p2queue2.h"
#include "p2stack.h"
#include "p2priorityqueue.h"
using namespace std;

int main(){

    string command;
    int number;

    //Declare data structures for the box.
    Queue<int> queue;
    Stack<int> stack;
    PriorityQueue<int, int> moreImportantQueue;

    //Initialize all queues at the same time.
    initialize(queue);
    initialize(stack);
    initialize(moreImportantQueue);

    bool poppingFromQueue = true;
    bool poppingFromStack = true;
    bool poppingFromMoreImportantQueue = true;

    //Stop taking commands if user types "END".
    cout << "Command: ";
    cin >> command;
    
    while(command != "END"){

        cin >> number;

        if(command == "PUSH"){
            push(queue, number);
            push(stack, number);
            push(moreImportantQueue, number, number);
        }
        /*When popping, the order in which the numbers come out will determine
        the type of structure. */
        if(command == "POP"){
            if(pop(queue) != number){
                poppingFromQueue = false;
            }
            if(pop(stack) != number){
                poppingFromStack = false;
            }
            if(pop(moreImportantQueue) != number){
                poppingFromMoreImportantQueue = false;
            }
        }

        cout << "Command: ";
        cin >> command;
    }
    cout << endl;

    //Select output by which structure was the number being poppep from.
    //The values are already set to true, so check if they're NOT(!).
    if(poppingFromQueue && !poppingFromStack && !poppingFromMoreImportantQueue){
        cout << "The black box holds a queue.";
    }
    else if(!poppingFromQueue && poppingFromStack && !poppingFromMoreImportantQueue){
        cout << "The black box holds a stack.";
    }
    else if(!poppingFromQueue && !poppingFromStack && poppingFromMoreImportantQueue){
        cout << "The black box holds a priority queue.";
    }
    //Verifies if more than one is true.
    else if(poppingFromQueue || poppingFromStack || poppingFromMoreImportantQueue){
        cout << "The black box remains mysterious.";
    }
    else{
        cout << "The black box holds something else.";
    }

    //Destroy all data structures at the same time.
    destroy(queue);
    destroy(stack);
    destroy(moreImportantQueue);

}