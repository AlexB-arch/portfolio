# Runs in O(n)
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