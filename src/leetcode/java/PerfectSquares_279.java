package leetcode.java.medium;

public class PerfectSquares_279 {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) dp[i] = Integer.MAX_VALUE;

    int sqrt, diff;
    for (int i = 1; i <= n; i++) {
      sqrt = (int) Math.sqrt(i);
      if (sqrt * sqrt == i) {
        dp[i] = 1;
        continue;
      }
      for (int j = 1; j <= sqrt; j++) {
        diff = i - j * j;
        dp[i] = Math.min(dp[i], dp[diff] + 1);
      }
    }
    return dp[n];
  }
}
