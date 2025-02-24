#one, two, three, four, five, six, seven, eight, nine
ones = [3,3,5,4,4,3,5,5,4]

#ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen
teens = [3,6,6,8,8,7,7,9,8,8]

#twenty, thirty, forty, fifty, sixty, seventy, eighty, ninety
tens = [6,6,5,5,5,7,6,6]
# hundred, one thousand, and
hundred = 7
oneThousand = 11
andWord = 3

grandTotal = 0

def CountTo99():
  return (sum(tens) * 10) + (sum(ones) * 10) + sum(teens)

def CountTo999():
  total = 0
  hundreds = 0

  for num in ones:
    hundreds += num + hundred
    total += (hundreds + andWord) * 99
    total += CountTo99()
  return total

grandTotal = CountTo99() + CountTo999() + oneThousand
print("Total: ", grandTotal)