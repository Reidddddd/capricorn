package leetcode.java;

public class CountNumbersWithUniqueDigits_357 {
  // Stores:
  // [0]: 9,
  // [1]: 9 * 8,
  // [2]: 9 * 8 * 7,
  // [3]: 9 * 8 * 7 * 6,
  // [4]: 9 * 8 * 7 * 6 * 5,
  // [5]: 9 * 8 * 7 * 6 * 5 * 4,
  // [6]: 9 * 8 * 7 * 6 * 5 * 4 * 3,
  // [7]: 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2,
  // [8]: 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1,
  // [9]: 0,
  private static int[] uniques = new int[10];
  static {
    int num = 9;
    uniques[0] = 9;
    for (int i = 1; i < uniques.length; i++) {
      uniques[i] = uniques[i - 1] * (--num);
    }
    uniques[9] = 0;
  }

  public int countNumbersWithUniqueDigits(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      if (i > 10) break;
      // dp[i] = dp[i - 1](leading zero) + 9(non leading zero) * (remaining possibility)9 * 8 * .. 
      dp[i] = dp[i - 1] + uniques[0] * (i - 2 > 0 ? uniques[i - 2] : 1);
    }
    if (n > 10) return dp[10];
    return dp[n];
  }
}
