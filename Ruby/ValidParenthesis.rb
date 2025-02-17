def valid_parentheses(s)
  stack = []
  mapping = { ')' => '(', ']' => '[', '}' => '{' }

  s.each_char do |char|
    if mapping.key?(char)
      return false if stack.empty? || stack.pop != mapping[char]
    else
      stack.push(char)
    end
  end

  stack.empty?
end

# Uncomment below lines to test the method:
# p valid_parentheses("()")      # Expected output: true
# p valid_parentheses("()[]{}")  # Expected output: true
# p valid_parentheses("(]")      # Expected output: false
# p valid_parentheses("([])")    # Expected output: true
