#include "p2stack.h"

template <typename T>
struct Queue {
   Stack<T> s1;
   Stack<T> s2;
};

template <typename T>	
void initialize(Queue<T>& queueThree){
    initialize(queueThree.s1);
    initialize(queueThree.s2);
}

template <typename T>
void destroy(Queue<T>& queueThree){
    destroy(queueThree.s1);
    destroy(queueThree.s2);
}

template <typename T>
int  getSize(Queue<T>queueThree){

    //returns both stack values to simulate a single queue.
    return getSize(queueThree.s1) + getSize(queueThree.s2);
}

template <typename T>
bool isEmpty(Queue<T>queueThree){
    //Only return true if both are empty.
    if(isEmpty(queueThree.s1) && isEmpty(queueThree.s2)){
        return true;
    }
    else
    return false;
    

}

template <typename T>
void push(Queue<T>& queueThree, T pushSomething){
    //If values where passed on to s2, return them to keep original order.
     while(!isEmpty(queueThree.s2)){
            push(queueThree.s1, pop(queueThree.s2));
        }
    push(queueThree.s1, pushSomething);
}

template <typename T>
T    pop(Queue<T>& queueThree){

    //Takes the values from s1 and pops in the order they were pushed to s1.
     while(!isEmpty(queueThree.s1)){
            push(queueThree.s2, pop(queueThree.s1));
        }
    
       return pop(queueThree.s2);
}	