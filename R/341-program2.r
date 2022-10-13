
# Function that generates (x,y) nodes.
# Input: vectors x and y values
# Output: (x,y) nodes as a data frame
x <- c(1,2,3,4,5)
y <- c(1,4,9,16,25)
nodes <- data.frame(x,y)

# Compute the Lagragange basis recursively.
l <- function(x, nodes){
    r <- vector()
    if (length(nodes$x) == 1) {
        return(1)
    } 
    else {
        for(m in 1:length(nodes$x)){
            for(j in 1:length(nodes$x)){
                if(m != j){
                  r <- c((x - nodes$x[j])/(nodes$x[m] - nodes$x[j]))
                }
                results <- data.frame(x, r)
            }
        }
    }
    
    colnames(results) <- c("x", "l(x)")
    return(results)
}
df <- data.frame()

for(i in 1:length(x)){
    df <- l(x[i], nodes)
}
