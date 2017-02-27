package leetcode.java.medium;

public class NumberOfIslands_200 {
  private int row, col;

  public int numIslands(char[][] grid) {
    int island = 0;
    if (grid.length == 0) return island;
    row = grid.length;
    col = grid[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        island += dfs(grid, i, j);
      }
    }
    return island;
  }

  private int dfs(char[][] grid, int i, int j) {
    if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') return 0;
    grid[i][j] = '1';
    dfs(grid, i, j + 1);
    dfs(grid, i + 1, j);
    dfs(grid, i, j - 1);
    dfs(grid, i - 1, j);
    return 1;
  }
}
