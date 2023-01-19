#Let g(x) = 100/x^2 * sin(10/x) and x0 = 1.25. Find x1 and x2 of Newton’s method.
print("8")
#Define the function
g <- function(x) 100/x^2 * sin(10/x)

#Define the derivative of the function
dg <- function(x) -((200 * sin(10/x))/x^3) - ((1000 * cos(10/x))/x^4)

#Define the Newton's method function
newton <- function(x0, g, dg, tol = 1e-6, maxiter = 100) {
  x <- x0
  for (i in 1:maxiter) {
    xnew <- x - g(x)/dg(x)
    if (abs(xnew - x) < tol) {
      return(xnew)
    }
    x <- xnew
  }
  stop("Newton's method did not converge")
}

#Define the initial value
x0 <- 1.25

#Find the first root
x1 <- newton(x0, g, dg)

#Find the second root
x2 <- newton(x1, g, dg)

#Print the results
print(x1)
print(x2)

#Let g(x) = 2ln(1 + x^2) − x. Find x2 and x3 using the secant method with x0 = 1 and x1 = 2.
print("10b")
#Define the function
g <- function(x) 2 * log(1 + x^2) - x

#Define the secant method function
secant <- function(x0, x1, g, tol = 1e-6, maxiter = 100) {
  for (i in 1:maxiter) {
    xnew <- x1 - g(x1) * (x1 - x0)/(g(x1) - g(x0))
    if (abs(xnew - x1) < tol) {
      return(xnew)
    }
    x0 <- x1
    x1 <- xnew
  }
  stop("Secant method did not converge")
}

#Define the initial values
x0 <- 1
x1 <- 2

#Find the second root
x2 <- secant(x0, x1, g)

#Find the third root
x3 <- secant(x1, x2, g)

#Print the results
print(x2)
print(x3)



#Compute the first three iterations of Newton’s method
#applied to g(x) = x − (√2)x with x0 = 3
print("12")
#Define the function
g <- function(x) x - sqrt(2) * x

#Define the derivative of the function
dg <- function(x) 1 - sqrt(2)

#Define the Newton's method function
newton <- function(x0, g, dg, tol = 1e-6, maxiter = 100) {
  x <- x0
  for (i in 1:maxiter) {
    xnew <- x - g(x)/dg(x)
    if (abs(xnew - x) < tol) {
      return(xnew)
    }
    x <- xnew
  }
  stop("Newton's method did not converge")
}

#Define the initial value
x0 <- 3

#Find the first three roots
x1 <- newton(x0, g, dg)
x2 <- newton(x1, g, dg)
x3 <- newton(x2, g, dg)

#Print the results
print(x1)
print(x2)
print(x3)

#Find a value of x0 for which Newton’s method will fail
#to converge to a root of g(x) = 2 + x − e^x.
print("13")
#Define the function
g <- function(x) 2 + x - exp(x)

#Define the derivative of the function
dg <- function(x) 1 - exp(x)

#Define the Newton's method function
newton <- function(x0, g, dg, tol = 1e-6, maxiter = 100) {
  x <- x0
  for (i in 1:maxiter) {
    xnew <- x - g(x)/dg(x)
    if (abs(xnew - x) < tol) {
      return(xnew)
    }
    x <- xnew
  }
  stop("Newton's method did not converge")
}

#Define the initial value
x0 <- 1

#Find the first root
x1 <- newton(x0, g, dg)

#Print the results
print(x1)


#Explain why Newton’s method fails to converge for the
#the function g(x) = x2 + x + 1 with x0 = 1.
print("14")
#Define the function
g <- function(x) x^2 + x + 1

#Define the derivative of the function
dg <- function(x) 2 * x + 1

#Define the Newton's method function
newton <- function(x0, g, dg, tol = 1e-6, maxiter = 100) {
  x <- x0
  for (i in 1:maxiter) {
    xnew <- x - g(x)/dg(x)
    if (abs(xnew - x) < tol) {
      return(xnew)
    }
    x <- xnew
  }
  stop("Newton's method did not converge")
}

#Define the initial value
x0 <- 1

#Find the first root
x1 <- newton(x0, g, dg)

#Print the results
print(x1)




#Suppose you are using the secant method with x0 = 1
#and x1 = 1.1 to find a root of f (x).
#(a) Find x2 given that f (1) = 0.3 and f (1.1) = 0.23.
#(b) Create a sketch (graph) that illustrates the calcu-
#lation. HINT: x2 will be located where the line
#through (x0, f (x0)) and (x1, f (x1)) crosses the x-
#axis.
print("22")
#Define the function
g <- function(x) 0.3 + 0.23 * (x - 1)

#Define the secant method function
secant <- function(x0, x1, g, tol = 1e-6, maxiter = 100) {
  for (i in 1:maxiter) {
    xnew <- x1 - g(x1) * (x1 - x0)/(g(x1) - g(x0))
    if (abs(xnew - x1) < tol) {
      return(xnew)
    }
    x0 <- x1
    x1 <- xnew
  }
  stop("Secant method did not converge")
}

#Define the initial values
x0 <- 1
x1 <- 1.1

#Find the second root
x2 <- secant(x0, x1, g)

#Print the results
print(x2)



#Use the graph of g to answer the following questions.
#g has roots at −2π, −π, π, and 2π
#(a) To which root will Newton’s method converge if x0 = 2.5?
#(b) What will happen if x0 = 0?
#(c) Find a positive integer value of x0 for which Newton’s method will converge to 2π.
#(d) Find a negative value of x0 for which Newton’s method will converge to 2π.
print("23")
#Define the function
g <- function(x) x - 2 * pi * floor((x + pi)/(2 * pi))

#Define the derivative of the function
dg <- function(x) 1

#Define the Newton's method function
newton <- function(x0, g, dg, tol = 1e-6, maxiter = 100) {
  x <- x0
  for (i in 1:maxiter) {
    xnew <- x - g(x)/dg(x)
    if (abs(xnew - x) < tol) {
      return(xnew)
    }
    x <- xnew
  }
  stop("Newton's method did not converge")
}

#Define the initial value
x0 <- 2.5

#Find the first root
x1 <- newton(x0, g, dg)

#Print the results
print(x1)