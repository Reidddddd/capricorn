package leetcode.java;

public class MaximumProductSubarray_152 {
  public int maxProduct(int[] nums) {
    int r = nums[0];
    int tmp;
    for (int i = 1, tmax = r, tmin = r; i < nums.length; i++) {
      if (nums[i] < 0) {
        tmp = tmax;
        tmax = tmin;
        tmin = tmp;
      }
      tmax = Math.max(nums[i], tmax * nums[i]);
      tmin = Math.min(nums[i], tmin * nums[i]);
      r = Math.max(r, tmax);
    }
    return r;
  }
}
