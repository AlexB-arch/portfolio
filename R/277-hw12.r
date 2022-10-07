#1. Find all possible partitions of the set {𝑎, 𝑏, 𝑐, 𝑑}.

# Solution
# a, b, c, d
# a, b, cd
# a, bc, d
# a, bcd
# ab, c, d
# ab, cd
# abc, d
# abcd

#2. How many different anagrams (arrangements, including nonsensical words) can be made
#from the following words: (how many different ways can the letters be rearranged?)
#(a) zigzagged
#(b) embezzlement
#(c) bamboozlements
#(d) staphylococcal

# Solution
a <-  factorial(9)/factorial(3) * factorial(2)
b <- factorial(12)/factorial(4) * factorial(2) * factorial(2)
c <- factorial(14)/factorial(2) * factorial(2) * factorial(2) * factorial(2)
d <- factorial(14)/factorial(3) * factorial(2) * factorial(2) * factorial(2)

banana <- factorial(6)/factorial(3)*factorial(2)


#3. Ten boys and ten girls join hands for a circle dance so that they alternate in sex around the circle. In how many ways can they do this?

# Solution
# 10! * 10! / 10! = 10! * 10! = 10!^2 = 10^20

#4. Twenty-four people are to be divided into four groups of six. In how many ways can this be done?

# Solution


# 5. How many partitions, with exactly two parts, can be made from the set {1, 2, 3, 4}? What about for the set {1, 2, 3, . . . , 50}?

# Solution