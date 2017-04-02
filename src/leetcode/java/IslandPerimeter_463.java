package leetcode.java;

public class IslandPerimeter_463 {
  public int islandPerimeter(int[][] grid) {
    int[] per = new int[5];
    int row = grid.length;
    int col = grid[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) per[getPerimeter(grid, i, j, row, col)]++;
      }
    }
    int res = 0;
    for (int i = 1; i < per.length; i++) {
      res += i * per[i];
    }
    return res;
  }

  private int getPerimeter(int[][] grid, int i, int j, int row, int col) {
    int perimeter = 0;
    if (i - 1 < 0 || grid[i - 1][j] == 0) perimeter++;
    if (i + 1 >= row || grid[i + 1][j] == 0) perimeter++;
    if (j - 1 < 0 || grid[i][j - 1] == 0) perimeter++;
    if (j + 1 >= col || grid[i][j + 1] == 0) perimeter++;
    return perimeter;
  }
}
