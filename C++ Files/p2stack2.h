#include <cstddef>

template <typename T>
struct Node {
   T value;
   Node<T>* next;
};

template <typename T>
struct Stack {
   Node<T>* top;
};

template <typename T>
void initialize(Stack<T>& stackTwo){
    stackTwo.top = NULL;
}

template <typename T>
void destroy(Stack<T>& stackTwo){
    stackTwo.top = NULL;
}

template <typename T>
bool isEmpty(Stack<T>& stackTwo){
    if(stackTwo.top != NULL)
        return false;

    return true;
}

template <typename T>
void push(Stack<T>& stackTwo, T pushSomething){
    if(isEmpty(stackTwo))
        stackTwo.top->value = pushSomething;

    if(!isEmpty(stackTwo)){
        stackTwo.top->next->value = pushSomething;
    }
}

template <typename T>
T pop(Stack<T>& stackTwo){ 
    return stackTwo.top->value;
    stackTwo.top = NULL; 
    
}