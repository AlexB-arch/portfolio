# O(n log n)
def countPrimeFactors(n):
    # Initialize smallest prime factor array
    smallestPrime = [i for i in range(n + 1)]
    
    # Compute smallest prime factors using sieve
    for i in range(2, int(n**0.5) + 1):
        if smallestPrime[i] == i:
            for multiple in range(i * i, n + 1, i):
                if smallestPrime[multiple] == multiple:
                    smallestPrime[multiple] = i
    
    totalFactors = 0
    distinctPrimes = set()
    
    # Factorize each number and count prime factors
    for num in range(2, n + 1):
        while num > 1:
            prime = smallestPrime[num]
            distinctPrimes.add(prime)
            count = 0
            while num % prime == 0:
                count += 1
                num //= prime
            totalFactors += count
    
    distinctFactors = len(distinctPrimes)
    return totalFactors, distinctFactors

# Test cases
print(countPrimeFactors(5))
print(countPrimeFactors(100))
print(countPrimeFactors(1000))