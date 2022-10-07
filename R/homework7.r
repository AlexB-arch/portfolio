
#P(b>x) <- pnorm(b)
#P(x>a) <- 1 - pnorm(a)
#P(a>x)=q <- qnorm(q)
#P(a<x<b) <- pnorm(b) - pnorm(a)

# 4.54
ex454a <- pnorm(1.3) - pnorm(0.5)
ex454b <- pnorm(-1.3) - pnorm(0)

# 4.55
ex455a <- pnorm(-2.5) - pnorm(-1.2)
ex455b <- pnorm(-1.3) - pnorm(-0.7)

# 4.57
ex457 <- pnorm(1.23)

# 4.60
# P(z > z0)
ex460 <- 1 - 0.0025

# 4.61
# P(z < z0)
ex461 <- 1 - 0.0091

# 4.64
#z <- (y - y0) / s
ex464a <- pnorm(50, 50)
ex464b <- pnorm(53, 50, 8)
ex464c <- pnorm(58, 50, 8)
ex464d <- pnorm(1.5) - pnorm(-1.5)
ex464e <- pnorm(1.5) - pnorm(-1.5)

# 4.68

ex468a <- 1 - 0.01