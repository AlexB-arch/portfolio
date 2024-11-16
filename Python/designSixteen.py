# Runs O(n * capacity)
def knapsack(values, weights, capacity):
    n = len(values)
    table = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

    # Build table
    for i in range(1, n + 1):
        for weight in range(1, capacity + 1):
            if weights[i-1] <= weight:
                table[i][weight] = max(values[i-1] + table[i-1][weight - weights[i-1]], table[i-1][weight])
            else:
                table[i][weight] = table[i-1][weight]

   
    maxValue = table[n][capacity]
    weight = capacity
    items = []

    for i in range(n, 0, -1):
        if maxValue <= 0:
            break
        if maxValue == table[i-1][weight]:
            continue
        else:
            items.append(i-1)
            maxValue -= values[i-1]
            weight -= weights[i-1]

    maxValue = table[n][capacity]
    print(f"Maximum value in Knapsack: {maxValue}")
    print("Items selected:")
    for i in items:
        print(f"Item {i}: Value = {values[i]}, Weight = {weights[i]}")

# Test
values = [10, 40, 30, 50]
weights = [5, 4, 6, 3]
capacity = 4

knapsack(values, weights, capacity)