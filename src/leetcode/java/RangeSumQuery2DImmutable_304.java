package leetcode.java;

public class RangeSumQuery2DImmutable_304 {
  private int[][] dp;

  public RangeSumQuery2DImmutable_304(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
    int row = matrix.length;
    int col = matrix[0].length;
    dp = new int[row + 1][col + 1];
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int minR = Math.min(row1, row2);
    int minC = Math.min(col1, col2);
    int maxR = Math.max(row1, row2);
    int maxC = Math.max(col1, col2);
    return dp[maxR + 1][maxC + 1] - dp[maxR + 1][minC] - dp[minR][maxC + 1] + dp[minR][minC];
  }
}
