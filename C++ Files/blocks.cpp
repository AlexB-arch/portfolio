// Recursive C++ program to 
// multiply array elements 
#include<iostream> 
  
using namespace std; 
  
// Function to calculate the  
// product of array using recursion 
int multiply(int a[], int n) 
{ 
    // Termination condition 
    if (n == 0) 
        return(a[n]); 
    else
        return (a[n] * multiply(a, n - 1)); 
} 
  
// Driver Code 
int main() 
{ 
    int array[] = {1, 7}; 
    int n = sizeof(array) / sizeof(array[0]); 
  
    // Function call to  
    // calculate the product 
    cout << multiply(array, n - 1)  
         << endl; 
    return 0; 
} 