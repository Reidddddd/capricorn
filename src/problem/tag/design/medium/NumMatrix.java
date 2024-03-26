package problem.tag.design.medium;

/**
 * 304. Range Sum Query 2D - Immutable
 * <p></p>
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * <p></p>
 */
public class NumMatrix {

  private int[][] matrix;

  public NumMatrix(int[][] matrix) {
    this.matrix = matrix;

    int row = matrix.length;
    int col = matrix[0].length;
    // init 1st row
    for (int i = 1; i < col; i++) {
      this.matrix[0][i] += this.matrix[0][i - 1];
    }
    // init 1st col
    for (int i = 1; i < row; i++) {
      this.matrix[i][0] += this.matrix[i - 1][0];
    }
    // init remaining
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        this.matrix[i][j] += (this.matrix[i - 1][j] + this.matrix[i][j - 1] - this.matrix[i - 1][j - 1]);
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return getValue(row2, col2) - getValue(row2, col1 - 1) -
           getValue(row1 - 1, col2) + getValue(row1 - 1, col1 - 1);
  }

  private int getValue(int row, int col) {
    if (row < 0) return 0;
    if (col < 0) return 0;
    return matrix[row][col];
  }

}
