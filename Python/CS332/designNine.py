# Runs in O(n) 
def searchMatrix(matrix, K):
    row = 0
    col = len(matrix[0]) - 1

    while row < len(matrix) and col >= 0:
        # if the matrix is uneven, return an error
        if len(matrix[row]) != len(matrix[0]):
            return "Invalid matrix"
        
        if matrix[row][col] == K:
            return "%s is in the matrix" % K
        
        elif matrix[row][col] < K:
            row += 1

        else:
            col -= 1

    return "%s is not in the matrix" % K

# Test Cases
matrix = [
    [16, 29, 48, 68, 89, 97, 112, 120],
    [31, 43, 57, 70, 92, 100, 117, 127],
    [45, 65, 94, 123, 133, 151, 165, 191],
    [60, 95, 111, 133, 155, 176, 186, 208],
    [80, 125, 155, 183, 193, 219, 233, 261],
    [102, 140, 181, 193, 220, 241, 259, 281],
    [121, 154, 204, 224, 245, 265, 285, 295],
    [144, 184, 218, 250, 261, 287, 300, 315]
]

K = 154
print(searchMatrix(matrix, K))  # True

K = 200
print(searchMatrix(matrix, K))  # False

K = 315
print(searchMatrix(matrix, K))  # True

K = 16
print(searchMatrix(matrix, K))  # True

K = 144
print(searchMatrix(matrix, K))  # True

K = 99
print(searchMatrix(matrix, K))  # False

# An uneven matrix
matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8]
]

K = 8
print(searchMatrix(matrix, K))  # Invalid matrix

