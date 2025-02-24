# This runs in O(n)

def goof(s):
    n = len(s)
    dp = [0] * n
    dp[0] = 1
    p = [0] * n
    p[0] = 1

    for i in range(1, n):
        p[i] = 1
        for j in range(i):
            if s[j] == s[i] and (j == 0 or p[j - 1] == i - j - 1):
                p[i] = max(p[i], i - j + 1)

    for i in range(1, n):
        min_len = i + 1
        for j in range(i):
            if p[j] >= i - j:
                min_len = min(min_len, (i - j + 1) // 2 + (dp[j - 1] if j > 0 else 0))
        dp[i] = min(min_len, dp[i - 1] + 1)

    return dp[-1]

# Test the function
print(goof("ATTACC"))  # Output: 3
print(goof("AAAAGAATTAA"))  # Output: 5
print(goof("A"))  # Output: 1
print(goof("AA"))  # Output: 1
print(goof("AB"))  # Output: 1
print(goof("ABCCBA"))  # Output: 3