# I found this solution online.
# Called the Sliding Window Method
# Runs in O(n)

def subArraySum(array, s):
    left = 0
    right = 0
    sum = 0
    min_length = len(array) + 1

    while right < len(array):
        sum += array[right]
        right += 1

        while sum >= s:
            min_length = min(min_length, right - left)
            sum -= array[left]
            left += 1

    return min_length if min_length != len(array) + 1 else 0
    

# Test cases
print(subArraySum([2,3,1,2,4,3], 7)) # 2
print(subArraySum([2,3,1,2,4,3], 100)) # 0
print(subArraySum([1,2,3,4,5], 11)) # 3