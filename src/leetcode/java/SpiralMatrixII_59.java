package leetcode.java;

public class SpiralMatrixII_59 {
  public int[][] generateMatrix(int n) {
    int left = -1, top = 0;
    int right = n - 1, down = n - 1;
    int[][] matrix = new int [n][n];
    int cnt = 0;

    while (left <= right) {
      for (int i = ++left; i <= right; i++) matrix[top][i] = ++cnt;
      for (int i = ++top; i <= down; i++) matrix[i][right] = ++cnt;
      for (int i = --right; i >= left; i--) matrix[down][i] = ++cnt;
      for (int i = --down; i >= top; i--) matrix[i][left] = ++cnt;
    }
    return matrix;
  }
}
