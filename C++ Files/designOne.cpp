/*Design and implement an algorithm that accepts a list of numbers and identifies the maximum subsequence sum, which is the largest sum that can be computed by adding together sequential numbers from the list. 

For example, consider this list: [ −1, 3, −2, 7, −9, 0, 7 ]
The solution is 3 + -2 + 7 = 8

Consider edge cases like:

    what if all numbers are positive? (the answer is the sum over the whole list)
    what if all numbers are negative? (the answer is 0, an empty subsequence)
    what if the list is empty? (the answer is 0, an empty subsequence)
    */

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int maxSubsequenceSum(vector<int> list){
    int maxSum = 0;
    int currentSum = 0;

    for(int i = 0; i < list.size(); i++){
        currentSum = max(0, currentSum + list[i]);
        maxSum = max(maxSum, currentSum);
    }

    return maxSum;
}

int main(){
    
    vector<int> list = { -1, 3, -2, 7, -9, 0, 7 };

    cout << maxSubsequenceSum(list) << endl;
}