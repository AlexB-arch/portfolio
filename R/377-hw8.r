# Print script as PDF
pdf("377-hw8.pdf")
cat("

# Sampling Distribution
# 4.79
ex479a <- pnorm(960, 930, 130 / sqrt(20)) - pnorm(900, 930, 130 / sqrt(20))
ex479b <- 1 - pnorm(960, 930, 130 / sqrt(20))
ex479c <- qnorm(.90, 930, 130 / sqrt(20))

# 4.82
ex482a <- 1 - pnorm(7, 5, 1.3)
ex482b <- pnorm(5.5, 5, 1.3 / sqrt(500))

# 4.83
ex483a <- 1 - pnorm(2.7, 2.1, 0.3)
ex483b <- qnorm(.75, 2.1, 0.3)
ex483c <- qnorm(.95, 0, 0.3)
ex483c2 <- 2.7 - ex483c
 
# 4.84
n <- 150
u <- 2.1
o <- 0.3

ex484a <- n * u
ex484b <- sqrt(n) * o

# 4.85
n <- 200
u <- 95
o <- 35

ex485a <- n * u
ex485b <- sqrt(n) * o
ex485c <- 1 - pnorm(20000, 19000, 495)
", file = "377-hw8.pdf", append = TRUE)