# Alex Burgos  09/27/2022
# MATH 377 Test 1

# 1
# Extracts data from file and separates by commas into two columns.
peopleData <- read.delim("377124.txt", header = TRUE, sep = ",")

# Mean
meanMales <- mean(peopleData$MALE)
meanFemales <- mean(peopleData$FEMALE)

# Median
medianMales <- median(peopleData$MALE)
medianFemales <- median(peopleData$FEMALE)

# Range
rangeMale <- range(peopleData$MALE)
rangeFemale <- range(peopleData$FEMALE)

# Variance
varianceMale <- var(peopleData$MALE)
varianceFemale <- var(peopleData$FEMALE)

# Standard Deviation
sdMale <- sd(peopleData$MALE)
sdFemale <- sd(peopleData$FEMALE)

# Maximum
maxMale <- max(peopleData$MALE)
maxFemale <- max(peopleData$FEMALE)

# Minimum
minMale <- min(peopleData$MALE)
minFemale <- min(peopleData$FEMALE)

# Using Summary to get Q1, Q3, and IQR
# Create a table
summaryTable <- summary.data.frame(peopleData)

# Then extract the information by row and column position
q1Male <- as.numeric(sub('.*:', '', summaryTable[2,1]))
q1Female <- as.numeric(sub('.*:', '', summaryTable[2,2]))

q3Male <- as.numeric(sub('.*:', '', summaryTable[4,1]))
q3Female <- as.numeric(sub('.*:', '', summaryTable[4,2]))

iqrMale <- q3Male - q1Male
iqrFemale <- q3Female - q1Female

# IQR from built-in function just in case, but the results are different
#iqrMale2 <- IQR(peopleData$MALE)
#iqrFemale2 <- IQR(peopleData$FEMALE)

cholesterolBoxplot <- boxplot(peopleData, 
    horizontal = T, 
    col = c("red", "blue"), 
    pch = 16, 
    boxwex = .8, 
    names = c("Males", "Females"))

##############################################################################

# 2
temps <- read.delim("377183.txt", header = TRUE)

tempsHistogram <- hist(temps$Temp, 
    breaks = 9, 
    main = "Everglades Temp. in Celcius", 
    xlab = "Temperature", 
    ylab = "Frequency", 
    col = "blue", 
    border = "black", 
    xlim = c(25.5, 35.5), 
    ylim = c(0, 20), 
    xaxp = c(25.5, 35.5, 5), 
    labels = T)

# 3
# 3a
carsA <- round((dbinom(0:5, 15, 0.3)), 4)

# 3b
carsB <- round(sum(dbinom(5:10, 15, 0.3)), 4)

# 3c
carsC <- round(sum(dbinom(10:15, 15, 0.3)), 4)

# 3d
carsDMean <- round(25 * (1 - .3), 4)
carsDSD <- round(sqrt((25 * .3 * (1 - .3))), 4)

# 3e
carsE <- round(pnorm(carsDMean + carsDSD, carsDMean, carsDSD) - pnorm(carsDMean - carsDSD, carsDMean, carsDSD), 4)
 
 #4
 wpmMean <- 60
 wpmSD <- 15

# 4a
 wpmA <- round(pnorm(55, wpmMean, wpmSD), 4)

# 4b
 wpmB <- round(pnorm(70, wpmMean, wpmSD) - pnorm(60, wpmMean, wpmSD), 4)

# 4c
wpmC <- round(1 - pnorm(85, wpmMean, wpmSD), 4)

# 4d
wpmD <- 1 - pnorm(108, wpmMean, wpmSD)

wpmE <- ((1 - pnorm(75, wpmMean, wpmSD)) + (1 - pnorm(75, wpmMean, wpmSD)))
