def four_sum(nums, target)
  result = []
  nums.sort!
  n = nums.length

  (0...n-3).each do |i|
    next if i > 0 && nums[i] == nums[i - 1]

    (i+1...n-2).each do |j|
      next if j > i+1 && nums[j] == nums[j - 1]

      left = j + 1
      right = n - 1

      while left < right
        sum = nums[i] + nums[j] + nums[left] + nums[right]
        if sum == target
          result << [nums[i], nums[j], nums[left], nums[right]]
          left += 1
          right -= 1

          # Skip duplicate values for left pointer
          left += 1 while left < right && nums[left] == nums[left - 1]
          # Skip duplicate values for right pointer
          right -= 1 while left < right && nums[right] == nums[right + 1]
        elsif sum < target
          left += 1
        else
          right -= 1
        end
      end
    end
  end

  result
end

# Uncomment below lines to test the method:
# p four_sum([1, 0, -1, 0, -2, 2], 0)  # Expected output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
# p four_sum([2, 2, 2, 2, 2], 8)        # Expected output: [[2, 2, 2, 2]]
