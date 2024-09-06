#include <cstddef>
    
    template <typename T>
    struct Set {
        T* data;
        int size;        
        int count;
    };
	
    template <typename T>
    void initialize(Set<T>& dynamicSet){
        dynamicSet.size = 2;
        dynamicSet.data = new T[dynamicSet.size];
        dynamicSet.count = 0;
    }

    template <typename T>
    void destroy(Set<T>& dynamicSet){
        delete [] dynamicSet.data;
        dynamicSet.data = NULL;
        dynamicSet.count = 0;
    }

    template <typename T>
    bool isEmpty(Set<T> dynamicSet){
        return dynamicSet.count == 0;
    }

    template <typename T>
    bool contains(Set<T> dynamicSet, T value){

        for(int j = 0; j < dynamicSet.count; j++)
            if(dynamicSet.data[j] == value)
                return true;
            
            return false;
    }

    template <typename T>
    void insert(Set<T>& dynamicSet, T value){

        if(contains(dynamicSet, value)){
            return;
        }

        if(dynamicSet.count == dynamicSet.size){

            T* tempSet = new T[dynamicSet.size*2];

            for(int i = 0; i < dynamicSet.count; i++){
                tempSet[i] = dynamicSet.data[i];
            }
            delete [] dynamicSet.data;
            dynamicSet.data = tempSet;
            dynamicSet.size*=2;
        }

        dynamicSet.data[dynamicSet.count] = value;
        dynamicSet.count++;
        
    }

    template <typename T>
    void remove(Set<T>& dynamicSet, T value){

        for(int k = 0; k < dynamicSet.count; k++){
            if(dynamicSet.data[k] == value){
                dynamicSet.data[k] = dynamicSet.data[dynamicSet.count-1];
                //Decreases count after removing the value and reorganizing the array.
        dynamicSet.count--;
        return;  }  
        }
        
         
    }

    template <typename T>
    int  getSize(Set<T>& dynamicSet){

        return dynamicSet.count;  
    }