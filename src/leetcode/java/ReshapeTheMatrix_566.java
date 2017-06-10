package leetcode.java;

public class ReshapeTheMatrix_566 {
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    int row = nums.length;
    int col = nums[0].length;
    if (r * c != row * col) return nums;
    int[][] res = new int[r][c];
    int k = 0, h = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        res[k][h] = nums[i][j];
        if (++h == c) {
          k++;
          h = 0;
        }
      }
    }
    return res;
  }
}
