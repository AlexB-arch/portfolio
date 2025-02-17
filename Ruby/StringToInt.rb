def my_atoi(s)
  s = s.lstrip
  return 0 if s.empty?

  sign = 1
  i = 0

  # check sign and adjust index
  if s[i] == '+' || s[i] == '-'
    sign = -1 if s[i] == '-'
    i += 1
  end

  result = 0
  # Read digits and build the number
  while i < s.length && s[i] =~ /\d/
    digit = s[i].to_i
    result = result * 10 + digit
    i += 1
  end

  result *= sign

  # Clamp to 32-bit signed integer range
  min_val = -2**31
  max_val = 2**31 - 1
  if result < min_val
    result = min_val
  elsif result > max_val
    result = max_val
  end

  result
end
