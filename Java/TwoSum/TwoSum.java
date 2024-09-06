class TwoSum {

    /*Given an array of integers nums and an integer target,return indices of the two numbers such that they add up
    to target.

    You may assume that each input would have exactly one solution, and you may not use the
    same element twice.

    You can return the answer in any order.*/

    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];

        for (int i = 0; i < nums.length; i++){
            for (int j = 1; j < nums.length; j++){
                // Make sure the same element is not used twice
                if (i != j){
                    // Check if the sum of the two elements is equal to the target
                    if (nums[i] + nums[j] == target){
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return result;
    }

    public static void main(int[] args){
    }
}