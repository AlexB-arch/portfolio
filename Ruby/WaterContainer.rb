def max_area(height)
  left = 0
  right = height.length - 1
  max_water = 0

  while left < right
    current_area = [height[left], height[right]].min * (right - left)
    max_water = [max_water, current_area].max
    if height[left] < height[right]
      left += 1
    else
      right -= 1
    end
  end

  max_water
end

# Uncomment below lines to test the method:
# puts max_area([1,8,6,2,5,4,8,3,7])  # Expected output: 49
