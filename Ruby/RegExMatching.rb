def is_match(s, p, memo = {})
  key = [s, p]
  return memo[key] if memo.key?(key)

  # Base case: if the pattern is empty, s must be empty for a match
  if p.empty?
    return s.empty?
  end

  # Check if the first character matches (considering '.')
  first_match = !s.empty? && (p[0] == s[0] || p[0] == '.')

  if p.length >= 2 && p[1] == '*'
    # Two cases:
    # 1. We can ignore the character and '*' in the pattern.
    # 2. If there's a first match, move to the next char in s.
    result = is_match(s, p[2..-1], memo) || (first_match && is_match(s[1..-1], p, memo))
  else
    result = first_match && is_match(s[1..-1], p[1..-1], memo)
  end

  memo[key] = result
  result
end

# Uncomment below lines to test the method:
# puts is_match("aa", "a")      # Expected output: false
# puts is_match("aa", "a*")     # Expected output: true
# puts is_match("ab", ".*")     # Expected output: true
