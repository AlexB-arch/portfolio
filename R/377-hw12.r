students <- read.delim("ex5-36.txt", sep = ",")

t536 <- qt(.95, 19)
p536 <- pt(2.573, 19)

#Plot the data
png("ex5-36.png")
plot(students$X.Comprehension, students$X.ReadTime, xlab = "Score", ylab = "Reading Time", main = "Student Reading Test")
abline(lm(students$X.ReadTime ~ students$X.Comprehension), col = "red")
dev.off()

t537 <- pnorm( 82.05, 10.88)