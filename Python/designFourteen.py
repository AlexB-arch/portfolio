# Runs in O(rows * columns)
def coinCollecting():
    board = [
        [0, 3, 1, 1],
        [2, 0, 0, 4],
        [1, 5, 3, 1],
        [2, 2, 2, 0]
    ]

    rows, columns = len(board), len(board[0])
    maxCoins = [[0 for _ in range(columns)] for _ in range(rows)]
    path = [[[] for _ in range(columns)] for _ in range(rows)]

    maxCoins[0][0] = board[0][0]
    path[0][0] = [(0, 0)]

    # Initialize row 0
    for column in range(1, columns):
        maxCoins[0][column] = maxCoins[0][column-1] + board[0][column]
        path[0][column] = path[0][column-1] + [(0, column)]

    # Initialize column 0
    for row in range(1, rows):
        maxCoins[row][0] = maxCoins[row-1][0] + board[row][0]
        path[row][0] = path[row-1][0] + [(row, 0)]

    for row in range(1, rows):
        for column in range(1, columns):
            if maxCoins[row-1][column] > maxCoins[row][column-1]:
                maxCoins[row][column] = maxCoins[row-1][column] + board[row][column]
                path[row][column] = path[row-1][column] + [(row, column)]
            else:
                maxCoins[row][column] = maxCoins[row][column-1] + board[row][column]
                path[row][column] = path[row][column-1] + [(row, column)]

    coins = maxCoins[rows-1][columns-1]
    wholePath = path[rows-1][columns-1]

    print(f"Maximum amount in coins collected: {coins}")
    print("Path:")
    for step in wholePath:
        print(step)

# Test
coinCollecting()