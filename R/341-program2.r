# Print a Lagrange polynomial for the given data points.
# Usage: Rscript 341-program2.r
# Input: 2 data points
# Output: Lagrange polynomial

# Function that generates (x,y) nodes.
# Input: x and y values
# Output: (x,y) nodes
generateNodes <- function(x, y) {
  nodes <- cbind(x, y)
  return(nodes)
}