# Runs in O(n*m)
def geometricConfections(A):
    reachable = set()
    V = max(A) * 2
    result = 0

    for n in range(1, V + 1):
        for m in A:
            if n - m in reachable or n == m:
                reachable.add(n)
                break
        else:
            result = n

    return result

# Test cases
print(geometricConfections([5, 8, 18]))
print(geometricConfections([6, 9, 20]))
print(geometricConfections([42, 91, 577]))
print(geometricConfections([1, 80, 123]))
print(geometricConfections([2, 3]))
print(geometricConfections([4,7]))
print(geometricConfections([216, 217]))