#1. Suppose 𝐴 ={1,2,3,4,5,6,7,8}, 𝐵 ={1,3,5,7,9,11}, and 𝐶 ={2,3,5,7,11,13}. Find
#(a) 𝐴 ∪ 𝐵
#(b) 𝐴 ∩ 𝐵
#(c) 𝐴 − 𝐵
#(d) 𝐴 − 𝐶
#(e) 𝐵 − 𝐴
#(f) 𝐴 △ 𝐵

# Solution
# (a) {1,2,3,4,5,6,7,8,9,11}
# (b) {1,3,5,7}
# (c) {2,4,6,8}
# (d) {1,2,4,6,8}
# (e) {9,11}
# (f) {1,2,4,6,8,9,11}

#2. Suppose 𝐴 = {0,1} and 𝐵 = {1,2}. Find
#(a) 𝐴 × 𝐴
#(b) (𝐴 × 𝐵)∩(𝐵 × 𝐵)
#(c) (𝐴 × 𝐵)∪(𝐵 × 𝐵)
#(d) (𝐴 × 𝐵)−(𝐵 × 𝐵)
#(e) 2^𝐴 ∩ 2^𝐵
#(f) 2^𝐴 − 2^𝐵

# Solution
# (a) {(0,0),(0,1),(1,0),(1,1)}
# (b) {(1,1)}
# (c) {(0,1),(1,0),(1,1),(1,2),(2,1)}
# (d) {(0,1),(1,0),(1,2),(2,1)}
# (e) {(0,0),(0,1),(1,0),(1,1)}
# (f) {(0,0),(0,1),(1,0)}


#3. Let 𝐴 be a set. Prove: 𝐴 △ 𝐴 = ∅

# Solution
#Let 𝑥 ∈ 𝐴 △ 𝐴. Then 𝑥 ∈ 𝐴 and 𝑥 ∈ 𝐴. Since 𝐴 is a set, 𝑥 ∈ 𝐴 ∩ 𝐴. Therefore 𝑥 ∈ ∅.

#4. Let 𝐴 be a set. Prove: 𝐴 △ ∅ = 𝐴.

# Solution
#Let 𝑥 ∈ 𝐴 △ ∅. Then 𝑥 ∈ 𝐴 and 𝑥 ∈ ∅. Since 𝐴 is a set, 𝑥 ∈ 𝐴 ∩ ∅. Therefore 𝑥 ∈ ∅.

#5. Let 𝐴 and 𝐵 be sets. Prove or disprove: 𝐴 ∪ 𝐵 =𝐴 ∩ 𝐵 if and only if 𝐴 = 𝐵.

# Solution
#Prove: 𝐴 ∪ 𝐵 = 𝐴 ∩ 𝐵 if and only if 𝐴 = 𝐵.
#If 𝐴 ∪ 𝐵 = 𝐴 ∩ 𝐵, then 𝐴 ∪ 𝐵 = 𝐴 ∩ 𝐵. Therefore 𝐴 = 𝐵.
#If 𝐴 = 𝐵, then 𝐴 ∪ 𝐵 = 𝐴 ∩ 𝐵. Therefore 𝐴 ∪ 𝐵 = 𝐴 ∩ 𝐵.

#7. Prove: If 𝑟 and 𝑠 are rational numbers with 𝑟 < 𝑠, then there is another rational number
#between 𝑟 and 𝑠

# Solution
#Let 𝑟 and 𝑠 be rational numbers with 𝑟 < 𝑠. Then 𝑟 < 𝑠. Let 𝑡 be a rational number between 𝑟 and 𝑠. Then 𝑟 < 𝑡 < 𝑠. Since 𝑟 < 𝑠, 𝑟 < 𝑠. Therefore 𝑟 < 𝑡 < 𝑠.

#Let g(x) = 100/x^2 * sin(10/x) and x0 = 1.25. Find x1 and x2 of Newton’s method.

# Solution
#x1 = 1.25 - 100/(1.25^2) * sin(10/1.25) / (200/1.25 - 10 * cos(10/1.25))