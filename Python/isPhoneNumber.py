# import regular expression module
import re

phoneNumberRegex = re.compile(r'\d\d\d-\d\d\d-\d\d\d\d') # This is a regular expression that looks for a phone number. \d is a digit character.

print('Enter a phone number: xxx-xxx-xxxx')

numberFound = phoneNumberRegex.search(input()) # This will search for a phone number in the string that the user inputs.

print('Phone number found: ' + numberFound.group()) # This will print the phone number found.