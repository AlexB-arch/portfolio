def three_sum(nums)
  result = []
  nums.sort!

  (0...nums.length - 2).each do |i|
    # Skip duplicate values for i
    next if i > 0 && nums[i] == nums[i - 1]

    left = i + 1
    right = nums.length - 1

    while left < right
      sum = nums[i] + nums[left] + nums[right]

      if sum < 0
        left += 1
      elsif sum > 0
        right -= 1
      else
        result << [nums[i], nums[left], nums[right]]
        left += 1
        right -= 1

        # Skip duplicate values for left and right
        left += 1 while left < right && nums[left] == nums[left - 1]
        right -= 1 while left < right && nums[right] == nums[right + 1]
      end
    end
  end

  result
end

# Uncomment below lines to test the method:
# p three_sum([-1, 0, 1, 2, -1, -4])   # Expected output: [[-1, -1, 2], [-1, 0, 1]]
# p three_sum([0, 1, 1])               # Expected output: []
# p three_sum([0, 0, 0])               # Expected output: [[0, 0, 0]]
