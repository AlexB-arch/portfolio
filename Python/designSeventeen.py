# Runs in O(n^3)
# Used https://github.com/TheAlgorithms/Python/blob/master/dynamic_programming/optimal_binary_search_tree.py
# as a reference

class Node:
    def __init__(self, key, freq):
        self.key = key
        self.freq = freq
        self.left = None
        self.right = None

    def __str__(self):
        return f"Node(key={self.key}, freq={self.freq})"

def print_bst(root, level=0):
    if root is not None:
        print_bst(root.right, level + 1)
        print(' ' * 4 * level + '*' * (level + 1) + ' ' + str(root.key))
        print_bst(root.left, level + 1)

def optimal_bst(keys, freq, n):
    cost = [[0 for x in range(n)] for y in range(n)]
    root = [[0 for x in range(n)] for y in range(n)]

    for i in range(n):
        cost[i][i] = freq[i]
        root[i][i] = i

    for L in range(2, n+1):
        for i in range(n - L +1):
            j = i + L -1
            cost[i][j] = float('inf') # type: ignore

            for r in range(i, j+1):
                c = 0
                if r > i:
                    c += cost[i][r-1]
                if r < j:
                    c += cost[r+1][j]
                c += sum(freq[i:j+1])
                if c < cost[i][j]:
                    cost[i][j] = c
                    root[i][j] = r

    def build_tree(keys, freq, root, i, j):
        if i > j:
            return None
        r = root[i][j]
        node = Node(keys[r], freq[r])
        node.left = build_tree(keys, freq, root, i, r-1) # type: ignore
        node.right = build_tree(keys, freq, root, r+1, j) # type: ignore
        return node

    tree = build_tree(keys, freq, root, 0, n-1)
    return cost[0][n-1], tree

def main():
    keys = [1, 2, 3, 4]
    freq = [0.1, 0.2, 0.4, 0.3]
    n = len(keys)

    min_cost, bst_root = optimal_bst(keys, freq, n)
    print(f"Minimum average number of comparisons: {min_cost}")
    print("Optimal BST structure:")
    print_bst(bst_root)

print(main())