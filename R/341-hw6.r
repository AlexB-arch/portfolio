library(orthopolynom)
library(ggplot2)
theme_set(theme_classic())
library(tidyr)
library(dplyr)
library(gridExtra)
library(grid)
library(base)

x <- seq(-2, 2, length.out = 4)

nodes <- c(-1, 0, 1)


f <- function(nodes) {
    1 / (1 + x^2)
}

fprime <- function(nodes) {
    -2 * x / (1 + x^2)^2
}

# Hermite polynomials

hermylist <- ghermite.h.polynomials(2, 1, normalized = FALSE)

h <- polynomial.functions(hermylist)

#plot the hermite polynomials
plot(nodes, h[[1]](nodes), type = "l", col = "blue", lwd = 2, xlab = "x", ylab = "Hermite polynomials", main = "Hermite polynomials")
lines(nodes, h[[2]](nodes), col = "red", lwd = 2)
lines(nodes, h[[3]](nodes), col = "green", lwd = 2)
# Chebyshev polynomials in the interval [-2, 2]
chebylist <- chebyshev.t.polynomials(4, normalized = FALSE)

cheb1 <- polynomial.functions(chebylist)


# plot all the polynomials
#plot(x, cheb1[[1]](x), type = "l", col = "red", ylim = c(-2, 2), xlim = c(-2, 2), xlab = "x", ylab = "y", main = "Chebyshev Polynomials")
#lines(x, cheb1[[2]](f(x)), col = "blue")
#lines(x, cheb1[[3]](f(x)), col = "green")
#lines(x, cheb1[[4]](f(x)), col = "orange")
#lines(x, cheb1[[5]](f(x)), col = "purple")

# table of divided differences

print("Divided Differences")
print("Hermite")
herm <- divided.differences(nodes, f(nodes), h[[1]](nodes), h[[2]](nodes), h[[3]](nodes))
print(herm)
print("Chebyshev")
cheb <- divided.differences(nodes, f(nodes), cheb1[[1]](nodes), cheb1[[2]](nodes), cheb1[[3]](nodes), cheb1[[4]](nodes))
print(cheb)
