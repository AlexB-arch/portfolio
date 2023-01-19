
#1. (12 points) A study is designed to test the hypothesis 𝐻0: 𝜇 ≥45 versus 𝐻𝑎: 𝜇 < 45. A
#random sample of 36 units was selected from a specified population that has a standard
#deviation of 𝜎 =8.4, and the measurements were summarized to 𝑦 =44.1.
#(a) With 𝛼 =0.05, is there substantial evidence that the population mean is less than 45?
#(b) Calculate the probability of making a Type II error if the actual value of the population
#mean is at most 42.
#(c) Find the values of the power curve for rejecting 𝐻0: 𝜇 ≥45 for the following values of
#𝜇: 39, 40, 41, 42, 43, and 44.
#(d) If the sample size is increased to 64, what is the probability of making a Type II error if
#the actual value of the population mean is at most 42.
#(e) If 𝛼 =0.05, what sample size is needed to have a probability of Type II error of at most
#0.025 if the actual mean is decreased to 43?

#2. (10 points) The eating habits of 12 bats were examined. These bats consume insects and
#frogs. For these 12 bats, the sample mean time to consume a frog was 21.1 minutes and the
#sample standard deviation was 7.7 minutes.
#(a) Construct and interpret a 95% confidence interval for the mean time for bats to eat a
#frog.
#(b) Test the claim that the mean time for a bat to eat a frog is greater than 17 minutes. Use
#𝛼 =0.05.

#3. (10 points) Acrylic bone cement is commonly used in total joint replacement to secure the
#artificial joint. Data on the force (measured in Newtons) required to break a cement bond
#under two different temperature conditions appear in the following table:
#Temperature Data on Breaking Force
#22 degrees 100.8 141.9 194.8 118.4 176.1 213.1
#37 degrees 302.1 339.2 288.8 306.8 305.2 327.5
#(a) Is there sufficient evidence to conclude that the mean breaking force at the higher
#temperature is greater than the mean breaking force at the lower temperature by more
#than 100 Newtons. Use 𝛼 =0.05.
#(b) Construct and interpret a 95% confidence interval for the mean difference in the
#breaking force of the two temperatures.
#(c) Are the results to parts (a) and (b) consistent? Explain.

#4. (12 points) The following data is from two surveys of kids 10 to 17. One survey was
#conducted in 1999 and the other was done in 2009. Data on the number of hours per day
#spent using electronic media. For the purposes of this problem, you can assume that the
#two samples are representative of kids ages 10 to 17 in each of the two years when the
#surveys were conducted.
#1999
#4 5 7 7 5 7 5 6
#5 6 7 8 5 6 6
#2009
#5 9 5 8 7 6 7 9
#7 6 6 9 10 9 8
#(a) Because the given sample sizes are small, what assumptions must be made about the
#distributions of electronic media use times for the two-sample 𝑡-test to be appropriate?
#Use the given data to construct boxplots to help in determining whether this
#assumption is reasonable. Do you think it is reasonable to carry out a 𝑡-test?
#(b) Does the data support the claim that the mean number of hours per day spent using
#electronic media is greater in 2009 than in 1999? Use 𝛼 =0.01.
#(c) Construct and interpret a 99% confidence interval for the difference in the mean
#number of hours per day spent using electronic media.
#(d) Are the results to parts (b) and (c) consistent? Explain.

#5. (10 points) The following data are the percentage of AP exams that earned credit in 1997
#and 2002 for seven high schools on the central coast of California and the percentage of
#students in grades 11 and 12 taking one or more AP exams in the same years for the same
#seven high schools.
#Percentage of AP Exams That Earned College Credit
#High School
#Year 1 2 3 4 5 6 7
#1997 61.4 65.3 65.1 65.9 42.3 60.4 42.9
#2002 52.8 74.5 72.4 61.9 62.7 53.5 62.2
#Percentage of Students Taking One or More AP Exams
#High School
#Year 1 2 3 4 5 6 7
#1997 13.6 20.7 8.9 17.2 18.3 9.8 15.7
#2002 18.4 25.9 13.7 22.4 43.5 11.4 17.2
#(a) Assuming that it is reasonable to regard these seven schools as a random sample of
#high schools located on the central coast of California, perform an appropriate 𝑡-test to
#determine if the mean percentage of AP exams earning college credit at central coast
#high schools in 1997 and 2002 were different. Use 𝛼 =0.05.
#(b) Is it reasonable to generalize the conclusion of the test in part (a) to all high schools in
#California? Explain.
#(c) Is it appropriate to do a 𝑡-test with the data on the percentage of students taking one or
#more AP exams? Explain.

# Solutions
# 1a.
# H0: mu >= 45
# Ha: mu < 45
# t = (44.1 - 45) / (8.4 / sqrt(36))
# t = -0.29
# t(0.05, 35) = -1.69
# Since t < t(0.05, 35), we fail to reject H0.

# 1b.
# H0: mu >= 42
# Ha: mu < 42
# t = (44.1 - 42) / (8.4 / sqrt(36))
# t = 0.29
# t(0.05, 35) = -1.69
# Since t > t(0.05, 35), we reject H0.

# 1c.
# Power Curves: mu = 39, 40, 41, 42, 43, 44
# H0: mu >= 45
# Ha: mu < 45
# t = (44.1 - mu) / (8.4 / sqrt(36))
# t = (44.1 - mu) / 2.2
# t = 1.86
# t(0.05, 35) = -1.69
# Since t > t(0.05, 35), we reject H0.
# Power = 1 - P(Type II error)
# P(Type II error) = P(t < t(0.05, 35))
# P(t < t(0.05, 35)) = P(t < -1.69)
# P(t < -1.69) = 0.95
# Power = 1 - 0.95 = 0.05


# 1d.
# H0: mu <= 42
# Ha: mu > 42
# t = (44.1 - 42) / (8.4 / sqrt(64))
# t = 0.29
# t(0.05, 63) = 1.69
# Since t < t(0.05, 63), we fail to reject H0.

# 1e.
# H0: mu <= 43
# Ha: mu > 43
# t = (44.1 - 43) / (8.4 / sqrt(64))
# t = 0.29
# t(0.05, 63) = 1.69
# Since t > t(0.05, 63), we reject H0.

#2a.
# H0: mu <= 17
# Ha: mu > 17
# t = (15.8 - 17) / (7.7 / sqrt(36))
# t = -0.16
