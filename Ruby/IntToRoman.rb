def int_to_roman(num)
  roman_mapping = {
    1000 => "M",
    900  => "CM",
    500  => "D",
    400  => "CD",
    100  => "C",
    90   => "XC",
    50   => "L",
    40   => "XL",
    10   => "X",
    9    => "IX",
    5    => "V",
    4    => "IV",
    1    => "I"
  }

  result = ""
  roman_mapping.each do |value, numeral|
    count = num / value
    result << numeral * count
    num %= value
  end

  result
end

# Uncomment below lines to test the method:
# puts int_to_roman(3)    # Expected output: "III"
# puts int_to_roman(4)    # Expected output: "IV"
# puts int_to_roman(9)    # Expected output: "IX"
# puts int_to_roman(58)   # Expected output: "LVIII"
# puts int_to_roman(1994) # Expected output: "MCMXCIV"
