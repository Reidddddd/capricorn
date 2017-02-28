package leetcode.java;

public class MinimumSizeSubarraySum_209 {
  public int minSubArrayLen(int s, int[] nums) {
    int minLen = Integer.MAX_VALUE;
    int i = 0, j = 0;
    int sum = 0;
    while (j < nums.length) {
      sum += nums[j++];
      while (sum >= s) {
        minLen = Math.min(minLen, j - i);
        sum -= nums[i++];
      }
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
}
