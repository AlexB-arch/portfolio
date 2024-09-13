# Given a list of sorted numbers A and B, find the values that are present in !both! lists.
# They can repeat. For example, if there are three 2's in A and two 2's in B, the output should be 2, 2.
# Must be O(m+n). 
def CommonValues(A, B):
  i = 0
  j = 0

  # Get the length of the lists
  lengthOfA = len(A)
  lengthOfB = len(B)

  # List to store the common values
  common = []

  # Loop through the lists
  while i < lengthOfA and j < lengthOfB:
    # If the values are equal, add them to the list
    if A[i] == B[j]:
      common.append(A[i])
      i += 1
      j += 1
    # If the value in A is less than the value in B, increment i
    elif A[i] < B[j]:
      i += 1
    # If the value in B is less than the value in A, increment j
    else:
      j += 1

  return common

# Test cases from the assignment
testA = [1,3,5,7,9]
testB = [1,2,3,4,5,6]

# Should return [1, 3, 5]
print(CommonValues(testA, testB))

anotherTestA = [1,2,2,2,4,4,4,4,5,5,5]
anotherTestB = [1,1,2,2,3,4]

# Should return [1, 2, 2, 4]
print(CommonValues(anotherTestA, anotherTestB))