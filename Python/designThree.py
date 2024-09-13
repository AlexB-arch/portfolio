# An array is wobbly when the value at each odd-numbered index is less than or equal to any adjacent values.
# Assume the array is unsorted.
# Describe an efficient algorithm that modifies the array values to hold a wobbly list that is a permutation of the original values in L.
# Must run on linear time, O(n).

import re
import time

def Wobbly(L):
  length = len(L)

  for i in range(1, length, 2):
    if i - 1 >= 0 and L[i] > L[i - 1]: # If the value at the odd-numbered index is greater than the value to the left
      L[i], L[i - 1] = L[i - 1], L[i]
    if i + 1 < length and L[i] > L[i + 1]: # If the value at the odd-numbered index is greater than the value to the right
      L[i], L[i + 1] = L[i + 1], L[i]

  return L


# Test cases
print(Wobbly([0,1,2,3,4]))
print(Wobbly([1,2,3,4,5]))
print(Wobbly([7,6,5,4,3,2,1]))

# Notes:
# Python arrays start at 0
# 0 is an even number based on the 2k definition
# the word "adjacent", in this case, means both values to the left and right of the odd-numbered index
# [0,1,2,3,4] should be seen as [even >= odd <= even >= odd <= even]