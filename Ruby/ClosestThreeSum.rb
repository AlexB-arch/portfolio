def three_sum_closest(nums, target)
  nums.sort!
  best = nums[0] + nums[1] + nums[2]

  (0...nums.length - 2).each do |i|
    left = i + 1
    right = nums.length - 1

    while left < right
      sum = nums[i] + nums[left] + nums[right]
      best = sum if (target - sum).abs < (target - best).abs
      return sum if sum == target

      if sum < target
        left += 1
      else
        right -= 1
      end
    end
  end

  best
end

# Uncomment below lines to test the method:
# p three_sum_closest([-1, 2, 1, -4], 1)  # Expected output: 2
# p three_sum_closest([0, 0, 0], 1)        # Expected output: 0
