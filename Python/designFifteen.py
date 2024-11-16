def makeChange(amount):
    coinDenominations = [25, 10, 5, 1]
    minCoinsRequired = [float('inf')] * (amount + 1)
    minCoinsRequired[0] = 0
    lastUsedCoin = [0] * (amount + 1)

    for coin in coinDenominations:
        for currentAmount in range(coin, amount + 1):
            if minCoinsRequired[currentAmount - coin] + 1 < minCoinsRequired[currentAmount]:
                minCoinsRequired[currentAmount] = minCoinsRequired[currentAmount - coin] + 1
                lastUsedCoin[currentAmount] = coin

    if minCoinsRequired[amount] == float('inf'):
        return None, None

    # Array to store the coins used
    coinsUsed = []
    remainingAmount = amount

    while remainingAmount > 0:
        coin = lastUsedCoin[remainingAmount]
        coinsUsed.append(coin)
        remainingAmount -= coin

    return minCoinsRequired[amount], coinsUsed

# Test
amount = 30
minimumCoins, coins = makeChange(amount)
if coins:
    print(f"Minimum number of coins: {minimumCoins}")
    print(f"Coins used: {coins}")
else:
    print("Change cannot be made with the given denominations.")