#include <iostream>
#include <sstream>
#include <algorithm>
#include "p2set1.h"
using namespace std;

void swap(int *xp, int *yp)  
{  
    int temp = *xp;  
    *xp = *yp;  
    *yp = temp;  
}  
  
void selectionSort(int arr[], int n)  
{  
    int i, j, min_idx;  
  
    // One by one move boundary of unsorted subarray  
    for (i = 0; i < n-1; i++)  
    {  
        // Find the minimum element in unsorted array  
        min_idx = i;  
        for (j = i+1; j < n; j++)  
        if (arr[j] < arr[min_idx])  
            min_idx = j;  
  
        // Swap the found minimum element with the first element  
        swap(&arr[min_idx], &arr[i]);  
    }  
}  
  
/* Function to print an array */
void printArray(int arr[], int size)  
{  
    int i;  
    for (i=0; i < size; i++)  
        cout << arr[i] << " ";  
    cout << endl;  
}
  
int main(){ 
    Set<int> filter;
    string line;
    int N, K, pro, count = 0, index = 0;
    int array[100];

    initialize(filter);
    //Allows the input of multiple numbers in a row, until user presser 'Enter.'
    getline(cin, line);
    stringstream ss(line);

    //Extract the prime numbers from the list.
    array[0] = 1;
    count = 1;
    
    while(ss>>N){
        array[count] = N;
        count++;
    }
    /*cout << "Going into the array: ";
    for(int j = 0; j < count; j++){
        cout << array[j] <<" ";
    }
    */
    cin >> K;

    //cout << "Going into results: ";
    int move = 0;
    for(int i = 0; i < 10; i++){
        for(int k = 0; k < count; k++){
            pro = (array[move]* array[k]);
            if(!contains(filter, pro)){
                insert(filter, pro);
                cout << pro << " ";
                array[index] = pro;
                index++;
                }
            }
        if(array[move+1] != 0 && move < count){
            move++;
        }
    }
    cout << endl;
    selectionSort(array, index);
    cout << endl;
    cout << "Actually in results: ";
    printArray(array, index);
    cout << endl;
    cout << "Result: " << array[K-1];
    destroy(filter);

} 