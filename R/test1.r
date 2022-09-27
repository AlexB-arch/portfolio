# Alex Burgos  09/27/2022
# MATH 377 Test 1

# 1
# Extracts data from file and separates by commas into two columns.
peopleData <- read.delim("377124.txt", header = TRUE, sep= ",")

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

b <- boxplot(peopleData, horizontal=T, col=c("red", "blue"), pch=16, boxwex=.8, names=c("Males", "Females"))

##############################################################################

# 2
temps <- read.delim("377183.txt", header = TRUE)

h <- hist(temps$Temp, breaks=seq(25.5, 35.5, 1), main="Everglades Temp. in Celcius", xlab="Temperature", ylab="Frequency", col="blue", border="black", xlim=c(25.5, 35.5), ylim=c(0, 20), xaxp=c(25.5, 35.5, 5), labels=T)