# Runs in O(n)

def findSum(A, B):
    results = {}

    # if the length of the array A is 0, return None
    if len(A) == 0:
        return None
    
    # if the length of the array B is 0, return None
    if len(B) == 0:
        return None
    
    for q in range(len(A)):
        results[A[q]] = 100 - A[q]
        if results[A[q]] in B:
            return [A[q], results[A[q]]]
        

# Test Cases
A = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
B = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
print(findSum(A, B))

A = [7, 13, 15, 20, 25, 30, 35, 40, 45]
B = [83, 84, 85, 90, 93]
print(findSum(A, B))

A = [1, 5, 9]
B = [91]
print(findSum(A, B))

A = [5]
B = [91, 92, 93, 94, 95]
print(findSum(A, B))
