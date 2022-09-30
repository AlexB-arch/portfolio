# Reads the text file and stores values
value <- read.table('ex3-15.txt', header = TRUE)

#3.15
# Calculates the mean before changing the values
calcMean <- mean(value$data)
calcMedian <- median(value$data)

#3.16
changeValue5 <- value$data[5] <- 378
changeValue6 <- value$data[6] <- 517

newMean <- mean(value$data)
newMedian <- median(value$data)

#3.26
years <- read.table('ex3-26.txt', header = TRUE)
meanYears <- mean(years$Experience)

# Delcaring the variables to run the sum loop
i <- 1
total <- 0

# Loop to calculate the sum of the years
sum_years <- while (i <= length(years$Experience)) {
  total <- (total + (years$Experience[i] - meanYears)^2)
  i <- i + 1
}

exp_variance <- var(years$Experience)
exp_sd <- sd(years$Experience)

#3.27
ages <- read.table('ex3-27.txt', header = TRUE)
ages_sd <- sd(ages$Age)

#3.28
ages_cv <- (sum(ages_sd) / mean(ages$Age))*100
exp_cv <- (sum(exp_sd) / mean(years$Experience))*100

ages_range <- range(ages)
exp_range <- range(years)

ages_sd <- (ages_range[2] - ages_range[1]) / 4
exp_sd <- (exp_range[2] - exp_range[1]) / 4

#3.30
num <- read.table('ex3-30.txt', header = TRUE)
hist(num$Number, breaks = 6, main = 'Relative Frequence', xlab = 'Diameter (inches)', ylab = 'Percent')

#3.54
dmg <- read.table('ex3-54.txt', header = TRUE)

hist(dmg$Damage, breaks = 5, main = 'Damages', xlab = 'Amount (in Dollars)', ylab = 'Frequency')

dmg_mean <- mean(dmg$Damage)
dmg_median <- median(dmg$Damage)