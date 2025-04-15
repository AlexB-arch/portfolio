from pathlib import Path, WindowsPath # Path is a class
import os
import sys

print(sys.platform) # prints the platform you are using
print(os.getcwd()) # get current working directory
print(Path.cwd()) # current working directory
print(Path.home()) # home directory

# Absolute path always starts at the root folder

# Relative path is relative to the current working directory

# creating a file
#os.makedirs(Path.cwd() / 'FromPythonScript/Nested') # creates a folder called FromPythonScript in the current working directory