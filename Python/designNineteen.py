# Runs in O(n * capacity)
# Assuming that the problem is like the knapsack problem from last week
def minimumCasketValue(weights, values, capacity):
    value = [float('inf')] * (capacity + 1)
    value[0] = 0  # Base case: 0 weight has 0 value.

    for i in range(len(weights)):
        for weight in range(weights[i], capacity + 1):
            value[weight] = min(value[weight], value[weight - weights[i]] + values[i])

    return value[capacity]

# Test case
weights = [2, 3, 4]  # weight of gemstones
values = [3, 4, 5]   # value of gemstones
capacity = 6     # casket capacity
print("Minimum Casket Value: " + str(minimumCasketValue(weights, values, capacity)))