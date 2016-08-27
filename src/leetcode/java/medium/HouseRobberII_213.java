package leetcode.java.medium;

public class HouseRobberII_213 {
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }

  private int rob(int[] nums, int start, int end) {
    int[] dp = new int[2];
    int tmp = 0;
    for (int i = start; i <= end; i++) {
      tmp = dp[1];
      dp[1] = nums[i] + dp[0];
      dp[0] = Math.max(dp[0], tmp);
    }
    return Math.max(dp[0], dp[1]);
  }
}
