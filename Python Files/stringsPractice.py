# Samples of strings
simplreString = "This is a simple string with double quotes"
escapeChar = 'This is Alex\'s string'
newLine = "This is a string with a new line\nand this is the new line"

#Printing the strings here
print(simplreString)
print(escapeChar)
print(newLine)

#Raw strings work by placing an 'r' before the string
print(r"This is a raw string with \n r and it ignores escape characters")

# A string can be indexed just like a list. This will print 'T'
indexingAString = "This is a string"
print(indexingAString[0])

# The 'in' and 'not' operators can be used to check if aa word is in a string
print('dog' in 'I have a dog') # True
print('Dog' in 'I have a dog') # This will return false because it is case sensitive
print('Dog' not in 'I have a dog') # True

#Concatenating strings
name = "Alex"
age = 31 # Convert to srting with str()
print("My name is " + name + " and I am " + str(age) + " years old.") # Basic way to concatenate strings
print("My name is %s and I am %s years old." % (name, age)) # Interpolating the strings. Does not need to convert integers to strings
print(f'My name is {name} and I am {age} years old.') # Using f strings

# String methods
# .upper()
allUpper = 'this will be uppercase'
print(allUpper.upper())

# .lower()
allLower = 'THIS WILL BE LOWERCASE'
print(allLower.lower())

# isupper()
print(allUpper.isupper()) # Returns false because it is not all uppercase
print(allLower.isupper()) # Returns true because it is all uppercase

# islower()
print(allUpper.islower()) # Returns true because it is all lowercase
print(allLower.islower()) # Returns false because it is not all lowercase

# isalpha()
print('Alphabetical'.isalpha()) # Returns true because it is all alphabetical and not blank
print('It is Alphabetical'.isalpha()) # Returns false because it has spaces or numbers

# isalnum()
print('string123'.isalnum()) # Returns true because it is alphanumeric with no spaces
print('string 123'.isalnum()) # Returns false because it has spaces

# isdecimal()
print('123'.isdecimal()) # Returns true because its only numbers
print('123.45'.isdecimal()) # Returns false because it has a decimal. The decimal point counts as a character
