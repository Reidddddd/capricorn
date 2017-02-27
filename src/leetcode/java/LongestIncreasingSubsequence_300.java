package leetcode.java.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int i, len = 0;
    for (int n : nums) {
      i = Arrays.binarySearch(dp, 0, len, n);
      if (i < 0) i = -(i + 1);
      dp[i] = n;
      if (i == len) len++;
    }
    return len;
  }
}
