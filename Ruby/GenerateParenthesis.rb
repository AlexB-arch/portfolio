def generate_parenthesis(n)
  result = []

  # backtrack function to build valid combinations
  backtrack = lambda do |str, open, close|
    if str.length == n * 2
      result << str
    else
      backtrack.call(str + "(", open + 1, close) if open < n
      backtrack.call(str + ")", open, close + 1) if close < open
    end
  end

  backtrack.call("", 0, 0)
  result
end

# Uncomment below lines to test the method:
# p generate_parenthesis(3)  # Expected output: ["((()))","(()())","(())()","()(())","()()()"]
# p generate_parenthesis(1)  # Expected output: ["()"]
