package leetcode.java;

public class MaxAreaOfIsland_695 {
  public int maxAreaOfIsland(int[][] grid) {
    int[] max = new int[2];
    int row = grid.length;
    int col = grid[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          dfs(grid, i, j, row, col, max);
          max[1] = Math.max(max[0], max[1]);
          max[0] = 0;
        }
      }
    }
    return max[1];
  }

  private void dfs(int[][] grid, int i, int j, int r, int c, int[] max) {
    if (i < 0 || i >= r || j < 0 || j >= c) return;

    if (grid[i][j] == 1) {
      max[0]++;
      grid[i][j] = 0;
      dfs(grid, i + 1, j, r, c, max);
      dfs(grid, i, j + 1, r, c, max);
      dfs(grid, i, j - 1, r, c, max);
      dfs(grid, i - 1, j, r, c, max);
    }
    return;
  }
}
