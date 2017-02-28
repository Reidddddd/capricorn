package leetcode.java;

public class UniquePaths_62 {
  public int uniquePaths(int m, int n) {
    if (m == 1 || n == 1) return 1;

    int[][] paths = new int[m][n];
    for (int i = 0; i < n; i++) paths[0][i] = 1;
    for (int j = 0; j < m; j++) paths[j][0] = 1;
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
      }
    }
    return paths[m - 1][n - 1];
  }
}
