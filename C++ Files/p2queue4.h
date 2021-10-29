#include <cstddef>

template <class T>
struct Queue {
    T*  data;	// array of values
    int size;	// size of data array
    int head;	// index from which the next value will be read (on Pop)
    int tail;	// index at which the next value will be written (on Push)
};

template <class T>
void initialize(Queue<T> &queueFour){
    queueFour.size = 2;
    queueFour.head = 0;
    queueFour.tail = 0;
    queueFour.data = new T[queueFour.size];
}

template <class T>
void destroy(Queue<T> &queueFour){
    queueFour.head = 0;
    queueFour.tail = 0;
    delete [] queueFour.data;
    queueFour.data = NULL;
}

template <class T>
int  getSize(Queue<T> queueFour){

    int count = 0;

    if(queueFour.tail < queueFour.head){
        count = (queueFour.size - 1) - queueFour.head + (queueFour.tail + 1);
    }
    else if(queueFour.tail > queueFour.head){
        count = queueFour.tail - queueFour.head;
    }
    if(count < 0){
        count *= -1;
    }
    return count;
}

template <class T>
bool isEmpty(Queue<T> queueFour){
    return queueFour.head == queueFour.tail;
}

template <class T>
void push(Queue<T> & queueFour, T pushSomething){

    queueFour.data[queueFour.tail] = pushSomething;
    queueFour.tail++;

    if (queueFour.tail > queueFour.size -1 ) {

        queueFour.tail = 0;
    }
   
    if (queueFour.head == queueFour.tail) {

        T* newQueue = new T[queueFour.size * 2];

        int index = queueFour.head;

        for (int i = 0; i < queueFour.size; i++) {
            newQueue[i] = queueFour.data[index];
            index++;

            if(index > queueFour.size-1){
                index = 0;
            }
        }

        delete[] queueFour.data;
        queueFour.data = newQueue;
        
        queueFour.head = 0;
        queueFour.tail = queueFour.size;

        queueFour.size *= 2;
        
    }
    
    
}

template <class T>
T    pop(Queue<T> &queueFour){

    T popSomething = queueFour.data[queueFour.head];
    queueFour.head++;

   if(queueFour.head > queueFour.size-1){
      
     queueFour.head = 0;
   } 

    return popSomething;
}