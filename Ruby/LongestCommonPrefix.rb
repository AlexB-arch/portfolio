def longest_common_prefix(strs)
  return "" if strs.empty?

  prefix = strs[0]
  strs[1..-1].each do |s|
    while !s.start_with?(prefix)
      prefix = prefix[0...-1]
      return "" if prefix.empty?
    end
  end

  prefix
end

# Uncomment below lines to test the method:
# puts longest_common_prefix(["flower", "flow", "flight"])  # Expected output: "fl"
# puts longest_common_prefix(["dog", "racecar", "car"])       # Expected output: ""
