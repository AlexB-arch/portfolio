# This should run at O(log_2(n))

def localMax(A):
    def search(left, right):
        if left == right:
            return left
        
        mid = (left + right) // 2
        
        if (mid == 0 or A[mid] > A[mid - 1]) and (mid == len(A) - 1 or A[mid] > A[mid + 1]):
            return mid
        
        elif mid > 0 and A[mid - 1] > A[mid]:
            left_max = search(left, mid - 1)
        else:
            left_max = mid
        
        if mid < len(A) - 1 and A[mid + 1] > A[mid]:
            right_max = search(mid + 1, right)
        else:
            right_max = mid
        
        return left_max if A[left_max] > A[right_max] else right_max

    return search(0, len(A) - 1)


# Test cases
print(localMax([9, 12, 16, 18, 15, 17, 8, 10, 6, 5, 14])) # Output: 5
print(localMax([1, 3, 20, 4, 1, 0])) # Output: 2
print(localMax([1,2,3,4,5])) # Output: 4
# The first test case picks the local maximum 17, 
# which in the example is k = 6 given that the array is index at 1, but here its 0-indexed.