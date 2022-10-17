# How to solve Taylor polynomials

# 1. Define the function
f <- function(x) {
  x^2
}

# 2. Define the derivative
fprime <- function(x) {
  2*x
}

# 3. Define the second derivative
fprimeprime <- function(x) {
  2
}

# 4. Define the third derivative
fprimeprimeprime <- function(x) {
  0
}

# 5. Define the fourth derivative
fprimeprimeprimeprime <- function(x) {
  0
}

# Then, the Taylor polynomial is:
# f(x) = f(0) + f'(0)(x-0) + f''(0)(x-0)^2/2! + f'''(0)(x-0)^3/3! + f''''(0)(x-0)^4/4!
# f(x) = 0 + 2(0)(x-0) + 2(x-0)^2/2! + 0(x-0)^3/3! + 0(x-0)^4/4!
# f(x) = 0 + 0 + 2(x-0)^2/2! + 0(x-0)^3/3! + 0(x-0)^4/4!
# f(x) = 2(x-0)^2/2! + 0(x-0)^3/3! + 0(x-0)^4/4!
# f(x) = 2(x)^2/2! + 0(x)^3/3! + 0(x)^4/4!
# f(x) = 2x^2

# 6. Define the Taylor polynomial
ftaylor <- function(x) {
  2*x^2
}

# 7. Plot the Taylor polynomial
plot(ftaylor, -2, 2, type="l", col="red", lwd=2, xlab="x", ylab="y", main="Taylor Polynomial")

