from pathlib import Path, WindowsPath # Path is a class

myPath = Path('/Users/alexander/OneDrive - acu.edu/Code/')

for filename in myPath.glob('*.py'):
    print(filename)
