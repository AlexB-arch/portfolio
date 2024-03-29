package leetcode;

public class MedianSortedArrays {
    /*
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
     * the median of the two sorted arrays.
     * 
     * The overall run time complexity should be O(log (m+n)).
     */

     public double findMedianSortedArray(int[] nums1, int[] nums2){
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        double median = 0.0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            }else{
                nums[k++] = nums2[j++];
            }
        }
        while(i < nums1.length){
            nums[k++] = nums1[i++];
        }
        while(j < nums2.length){
            nums[k++] = nums2[j++];
        }
        if(nums.length % 2 == 0){
            median = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        }else{
            median = nums[nums.length / 2];
        }
        return median;
     }
    
}
