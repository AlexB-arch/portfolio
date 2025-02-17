def roman_to_int(s)
  numeral_map = {
    'I' => 1,
    'V' => 5,
    'X' => 10,
    'L' => 50,
    'C' => 100,
    'D' => 500,
    'M' => 1000
  }

  total = 0

  s.chars.each_with_index do |char, i|
    value = numeral_map[char]
    # Check if the next numeral exists and if it is larger.
    if i < s.length - 1 && value < numeral_map[s[i + 1]]
      total -= value
    else
      total += value
    end
  end

  total
end

# Uncomment below lines to test the method:
# puts roman_to_int("III")     # Expected output: 3
# puts roman_to_int("IV")      # Expected output: 4
# puts roman_to_int("IX")      # Expected output: 9
# puts roman_to_int("LVIII")   # Expected output: 58
# puts roman_to_int("MCMXCIV") # Expected output: 1994
