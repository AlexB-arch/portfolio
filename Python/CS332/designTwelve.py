# Runs in O(n log n)
def profits(prices, left, mid, right):
    
    minPrice = min(prices[left:mid+1])
    maxPrice = max(prices[mid:right+1])

    return maxPrice - minPrice

def maxProfit(prices, left, right):
    # Do nothing if only one element
    if left >= right:
        return 0
    
    mid = (left + right) // 2

    leftProfit = maxProfit(prices, left, mid)
    rightProfit = maxProfit(prices, mid+1, right)
    crossProfit = profits(prices, left, mid, right)

    return max(leftProfit, rightProfit, crossProfit)

# Recursively find max profit
def highestSingleTransaction(prices):
    return maxProfit(prices, 0, len(prices)-1)

prices = [40, 20, 0, 0, 0, 1, 3, 3, 0, 0, 9, 21]
print("Max profit: ", highestSingleTransaction(prices))