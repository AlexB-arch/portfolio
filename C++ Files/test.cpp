#include <iostream>
#include <cassert>
#include "p2priorityqueue.h"
using namespace std;

int main()
{
    char A = 'A', B = 'B', C = 'C', popped;

    PriorityQueue<char,int> PQ;
    initialize(PQ);
    
    assert(PQ.head == NULL);
    assert(isEmpty(PQ));
    
    push(PQ,A,5);
    assert(PQ.head != NULL);
    assert(PQ.head->value == A);
    assert(PQ.head->priority == 5);
    assert(PQ.head->next == PQ.head);
    assert(PQ.head->prev == PQ.head);
    assert(!isEmpty(PQ));

    push(PQ,B,7);
    assert(PQ.head != NULL);
    assert(PQ.head->value == B);
    assert(PQ.head->priority == 7);
    assert(PQ.head->next != PQ.head);
    assert(PQ.head->next == PQ.head->prev);
    assert(PQ.head->next->value == A);
    assert(PQ.head->next->priority == 5);
    assert(PQ.head->next->next == PQ.head);
        
    push(PQ,C,5);
    assert(PQ.head != NULL);
    assert(PQ.head->value == B);
    assert(PQ.head->priority == 7);
    assert(PQ.head->next->value == A);
    assert(PQ.head->next->priority == 5);
    assert(PQ.head->next->next->value == C);
    assert(PQ.head->next->next->priority == 5);
    assert(PQ.head->next->next->next == PQ.head);
    assert(PQ.head->prev == PQ.head->next->next);
        
    popped = pop(PQ);
    assert(popped == B); // highest priority
    assert(PQ.head->value == A);
    assert(PQ.head->priority == 5);
    assert(PQ.head->next != PQ.head);
    assert(PQ.head->next == PQ.head->prev);
    assert(PQ.head->next->value == C);
    assert(PQ.head->next->priority == 5);
    assert(PQ.head->next->next == PQ.head);    
    
    popped = pop(PQ);
    assert(popped == A); // two of equal priority, but A longer in PQ
    assert(PQ.head->value == C);
    assert(PQ.head->priority == 5);
    assert(PQ.head->next == PQ.head);
    assert(PQ.head->prev == PQ.head);
    
    // Add more function calls and assertions
}