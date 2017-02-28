package leetcode.java;

public class IntegerBreak_343 {
  public int integerBreak(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int breakPoint;
    for (int i = 2; i <= n; i++) {
      breakPoint = i / 2;
      dp[i] =
          Math.max(
            Math.max(dp[breakPoint], breakPoint) * Math.max(dp[i - breakPoint], i - breakPoint),
            Math.max(dp[breakPoint - 1], breakPoint - 1) * Math.max(dp[i - breakPoint + 1], i - breakPoint + 1));
    }
    return dp[n];
  }
}
