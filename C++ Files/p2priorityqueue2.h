#include <cstddef>

template <typename V, typename R>
struct Node {
    V value;
    R priority;
    Node<V,R>* next;
    Node<V,R>* prev;    
};

template <typename V, typename R>
struct PriorityQueue {
    Node<V,R>* head;
};

template <typename V, typename R>
void initialize(PriorityQueue<V,R>& pq){
    //Starts the priority queue completely empty.
    pq.head = NULL;
}

template <typename V, typename R>
void destroy(PriorityQueue<V,R>& pq){
    //Returns the priority queue to completely empty.
    pq.head = NULL;
}

template <typename V, typename R>
bool isEmpty(PriorityQueue<V,R> pq){
    //Always assume that it's empty, unless the head is not NULL.
    if(pq.head != NULL){
        return false;
    }

    return true;
}

template <typename V, typename R>
void push(PriorityQueue<V,R>& pq, V inputValue, R inputPriority){
    if(isEmpty(pq)){
        //Will start at value and priority only if the queue is empty, otherwise, it will create new space.
        pq.head->value = inputValue;
        pq.head->priority = inputPriority;
    }
    
    if(!isEmpty(pq)){
        //Given that the priority queue must always have highest priority at the head,
        //values will be shifted every time a higher priority is entered.

        //If value is the same, but with a higher priority, update the current priority with the new input.
        if(pq.head->value == inputValue && pq.head->priority < inputPriority){
            pq.head->priority = inputPriority;
        }
        //If the value is different, but with same priority, create new space and populate.
        else if(pq.head->value != inputValue && pq.head->priority == inputPriority){
            pq.head->next->value  = inputValue;
            pq.head->next->priority = inputPriority;
        }
        //Else, if the new input value and priority are both different,
        //The next list must also be verified in orther to sort as needed.
        else if((inputValue != pq.head->value) && (inputPriority != pq.head->priority)){
            if(pq.head->priority < inputPriority){
                //Copy the now lower priority and value into the next list.
                pq.head->next->priority = pq.head->priority;
                pq.head->next->value = pq.head->value;
                //Then store the inputs in the head.
                pq.head->priority = inputPriority;
                pq.head->value = inputValue;
            }

            pq.head->next->value  = inputValue;
            pq.head->next->priority = inputPriority;
        }
    }
}

template <typename V, typename R>
V pop(PriorityQueue<V,R>& pq){
    return pq.head->value;
    pq.head->value = pq.head->next->value;
}