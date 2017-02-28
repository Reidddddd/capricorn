package leetcode.java;

public class LongestIncreasingPathInAMatrix_329 {
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0) return 0;
    int r = matrix.length;
    int c = matrix[0].length;
    int[][] visited = new int[r][c];
    int res = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        res = Math.max(res, dfs(matrix, i, j, visited));
      }
    }
    return res;
  }

  private int dfs(int[][] matrix, int i, int j, int[][] visited) {
    if (visited[i][j] != 0) return visited[i][j];
    int step = 0;
    if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) step = Math.max(dfs(matrix, i - 1, j, visited), step);
    if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) step = Math.max(dfs(matrix, i + 1, j, visited), step);
    if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) step = Math.max(dfs(matrix, i, j + 1, visited), step);
    if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) step = Math.max(dfs(matrix, i, j - 1, visited), step);
    visited[i][j] = (++step);
    return step;
  }
}
