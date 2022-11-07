#include <cstddef>
 #include <iostream>
 using namespace std;

template <class T>
struct Node {
    T data;
    Node<T>* next;
    Node<T>* prev;
};

template <class T>
struct List {
    Node<T>* head;
};

template <class T>
void initialize(List<T>& L)
{
    L.head = NULL;
}

template <class T>
void destroy(List<T>& L)
{
    if( L.head == NULL ) // emtpy list
        return; // nothing to do

    //break the circular list
    L.head->prev->next = NULL;

    Node <T>* walker = L.head;

    while(walker != NULL)
    {
        Node <T>* remove = walker;
        walker = walker->next;
        delete remove;    
    }

    L.head = NULL;
}

template <class T>
void append(List<T>& L,T val)
{
    Node<T>* n = new Node<T>;
    n->data = val;

    // special case for empty list
    if(L.head == NULL)
    {
        L.head = n;
        L.head->prev = L.head;
        L.head->next = L.head; 
        return;               
    }

    // normal case: nonempty list
    n->next = L.head;
    n->prev = L.head->prev;
    L.head->prev->next = n;
    L.head->prev = n;
}

template <class T>
bool isEmpty(List<T> L)
{
    return (L.head == NULL);
} 

template <class T>
int  getSize(List<T> L)
{
    // Handle empty list as special case
    if( L.head == NULL )
        return 0;

    int count = 0;

    // temporarily break the circular list
    L.head->prev->next = NULL;

    Node <T>* walker = L.head;
    while(walker!= NULL)
    {
        count++;
        walker = walker->next;    
    }

    // make the list circular again
    L.head->prev->next = L.head;

    return count;
}