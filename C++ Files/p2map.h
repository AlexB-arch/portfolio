#include <cstddef>

template <typename K, typename V>
struct Node {
    K key;
    V value;
    Node<K,V>* next;
};

template <typename K, typename V>
struct Map {
    Node<K,V>** table;
    int size;
};

template <typename K, typename V>  
void initialize(Map<K,V>& map, int desiredSize){
    map.table = new Node<K, V>*[map.size = desiredSize];
    map.table = NULL;
}

template <typename K, typename V>
void destroy(Map<K,V>& map){
    int index = map.size-1;
    // Deallocate every node in list
    // When complete, head will be NULL
    while( map.table != NULL ){
        Node<K, V>* pointer = map.table[index];
        delete map.table[index];
        index--;
        pointer = map.table[index];
    }

    delete [] map.table;
}

template <typename K, typename V>
void assign(Map<K,V>& map, K inputKey, V inputValue){
    //Every time you assign something new to the array, allocate new memory.
    Node<K, V>* newNode = new Node<K,V>;
    newNode->key = inputKey;
    newNode->value = inputValue;
    newNode->next = NULL;

    //If there is space, or previous item was deleted, in the array of pointers, create a Node in that index.
    if(map.table[(inputKey % map.size)] == NULL){
        map.table[(inputKey % map.size)] = newNode;
        return;
    }

    Node<K, V>* lastNode = map.table[(inputKey % map.size)];
    while(true){
        if(lastNode->next == NULL){
            break;
            lastNode = lastNode->next;
        }
    }

    lastNode->next = newNode;

}

template <typename K, typename V>
void remove(Map<K,V>& map, K inputKey){
    int index = (inputKey % map.size);
    //If the user wants to delete the first node, start here:
    if(index == 1){
        Node<K,V>* deleteThis = map.table[index];
        //Makes a copy of the original array to preserve it, but without the first node.
        delete deleteThis;
        return;
    }
    
    Node<K, V>* search = map.table[map.size];
    //Go through the array looking for the key, if present, delete it and deallocate memory.
    for(int i = 0; i < (inputKey % map.size)-1; i++){
        search = search->next;
    }
    //Once the key is found, save it here:
    Node<K, V>* deleteThis = search->next;

    //Your search variable will become the next node after the one to be deleted.
    search->next = search->next->next;

    delete deleteThis;

}

template <typename K, typename V>
bool has_key(Map<K,V>& map, K inputKey){
    int index = 0;
    //Verify all lists, if key is present, return true, otherwise, return false.
    Node<K, V>* searchThrough = map.table[index];

    while(searchThrough != NULL){
        if(searchThrough->key == (inputKey % map.size)){
            return true;
            searchThrough = searchThrough->next;
        }
        index++;
    }

    return false;
}

template <typename K, typename V>
V lookup(Map<K,V>& map, K inputKey){
   Node<K,V>* search = map.table[map.size];
    //Search through the array, if key is found, return that value to the user.
   for(int i = 0; i < (inputKey % map.size) -1; i++){
       search = search->next;
   }
   return search->value;
}