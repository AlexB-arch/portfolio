n <- 50
p <- 0.1
y <- 0

P <- (factorial(n) / (factorial(y) * factorial(n - y))) * p^y * (1 - p)^(n - y)

for(value in 1:50) {
  print(P)
}

sdP <- sd(P)
print(sd(dbinom(1:50, n, p)))
print(sdP)