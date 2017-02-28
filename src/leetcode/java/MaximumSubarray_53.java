package leetcode.java;

public class MaximumSubarray_53 {
  public int maxSubArray(int[] nums) {
    int max = nums[0], subMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(Math.max(subMax + nums[i], nums[i]), max);
    }
    return max;
  }
}
