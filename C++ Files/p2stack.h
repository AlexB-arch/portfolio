#include <cstddef>

    template <class T>
    struct Stack {
    T*  data;	// array of values
    int size;	// size of array
    int top;	// index of value currently at top of Stack
    };

    template <class T>
    void initialize(Stack<T>& dynamicStack){
        dynamicStack.size = 2;
        dynamicStack.top = 0;
        dynamicStack.data = new T[dynamicStack.size];
        
    }

    template <class T>
    void destroy(Stack<T>& dynamicStack){
        
        delete [] dynamicStack.data; 
        dynamicStack.data = NULL;
    }

    template <class T>
    bool isEmpty(Stack<T> dynamicStack){

        if(dynamicStack.top-1 < 0){
            return true;
        }
    
        return false;
    }

    template <class T>
    void push(Stack<T>& dynamicStack, T pushSomething){

        if( dynamicStack.top == dynamicStack.size ){
                
                    T* newStack = new T[dynamicStack.size*2];

                    for( int i = 0; i < dynamicStack.size; i++ )
                        newStack[i] = dynamicStack.data[i];

                    delete [] dynamicStack.data;
                    dynamicStack.data = newStack;
                    dynamicStack.size*=2;
                }

        dynamicStack.data[dynamicStack.top] = pushSomething;
        dynamicStack.top++;
    }

    template <class T>
    T    pop(Stack<T>& dynamicStack){

        T popSomething = dynamicStack.data[dynamicStack.top-1];
        dynamicStack.top--;
        
        return popSomething;
    
    }