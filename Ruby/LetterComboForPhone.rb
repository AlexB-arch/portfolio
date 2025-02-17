def letter_combinations(digits)
  return [] if digits.empty?

  mapping = {
    "2" => "abc",
    "3" => "def",
    "4" => "ghi",
    "5" => "jkl",
    "6" => "mno",
    "7" => "pqrs",
    "8" => "tuv",
    "9" => "wxyz"
  }

  result = []

  # Helper function for backtracking
  backtrack = lambda do |combination, next_digits|
    if next_digits.empty?
      result << combination
    else
      digit = next_digits[0]
      mapping[digit].each_char do |letter|
        backtrack.call(combination + letter, next_digits[1..-1])
      end
    end
  end

  backtrack.call("", digits)
  result
end

# Uncomment below lines to test the method:
# p letter_combinations("23")  # Expected output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
# p letter_combinations("")    # Expected output: []
# p letter_combinations("2")   # Expected output: ["a", "b", "c"]
