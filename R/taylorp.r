# Taylor's Polynomial
#
# Function to calculate the Taylor's Polynomial
taylorp <- function(x, y, x0, n) {
  y0 <- 0
  for (i in 1:n) {
    y0 <- y0 + (y[i] * (x0 - x[i])^i) / factorial(i)
  }
  return(y0)
}