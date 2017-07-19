package leetcode.java;

public class MaximumAverageSubarrayI_643 {
  public double findMaxAverage(int[] nums, int k) {
    int res = Integer.MIN_VALUE, window = 0, i = 0;
    for (; i < k; i++) window += nums[i];
    res = Math.max(res, window);
    for (; i < nums.length; i++) {
      window += (nums[i] - nums[i - k]);
      res = Math.max(res, window);
    }
    return (double) res / k;
  }
}
