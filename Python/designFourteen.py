# Runs in O(n)
# -Implement, in PHP, python, or C++, the Dynamic programming solution for the Robot Coin-collecting problem that was explained in class. 
# Make sure that you hardcode in your program the board containing the coins. 
# Your program should output both the maximum number of coins that the robot can collect and the path that the robot should follow to get this maximum number of coins. 
def max(a, b):
    if a > b:
        return a
    return b

def coin_row(coins):
    n = len(coins)

    if n == 1:
        return coins[0]
    
    if n == 2:
        return max(coins[0], coins[1])

    pickCoins = [0] * (n + 1)
    pickCoins[0] = 0
    pickCoins[1] = coins[0]

    for i in range(2, n + 1):
        pickCoins[i] = max(coins[i - 1] + pickCoins[i - 2], pickCoins[i - 1])

    return pickCoins[n]

# Test cases
print(coin_row([5, 1, 2, 10, 6, 2])) # 17
print(coin_row([1, 2, 3, 4, 5, 6])) # 12