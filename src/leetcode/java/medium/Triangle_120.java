package leetcode.java.medium;

import java.util.List;

public class Triangle_120 {
  public int minimumTotal(List<List<Integer>> triangle) {
    int row = triangle.size();
    if (row == 0) return 0;

    int[] dp = new int[row];
    int i = 0;
    for (int num : triangle.get(row - 1)) {
      dp[i++] = num;
    }
    List<Integer> layer;
    for (i = row - 2; i >= 0; i--) {
      layer = triangle.get(i);
      for (int k = 0; k < layer.size(); k++) {
        dp[k] = Math.min(dp[k], dp[k + 1]) + layer.get(k);
      }
    }
    return dp[0];
  }
}
