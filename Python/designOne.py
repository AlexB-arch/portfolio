import re


def MaxSubsequenceSum(listOfNumbers):
  total = 0
  maximum = 0

  #Catches an empty List edge case
  if not listOfNumbers:
    return 0
  # Catches the all negative numbers edge case
  if max(listOfNumbers) < 0:
    return 0
  
  for number in listOfNumbers:
    total += number

    if total < 0:
      total = 0

    if total > maximum:
      maximum = total
      
  return maximum

# Test cases
print(MaxSubsequenceSum([-1, 3, -2, 7, -9, 0, 7 ])) # 8
print(MaxSubsequenceSum([-1, -2, -3, -4, -5])) # 0
print(MaxSubsequenceSum([1, 2, 3, 4, 5])) # 15
print(MaxSubsequenceSum([])) # 0