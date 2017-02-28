package leetcode.java;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix_54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new LinkedList<>();
    if (matrix.length == 0) return result;
    
    int left = 0, right = matrix[0].length - 1;
    int top = 0, down = matrix.length - 1;
    while (left <= right && top <= down) {
      for (int i = left; i <= right; i++) result.add(matrix[top][i]);
      top++;
      for (int i = top; i <= down; i++) result.add(matrix[i][right]);
      right--;
      if (top <= down) {
        for (int i = right; i >= left; i--) result.add(matrix[down][i]);
        down--;
      }
      if (left <= right) {
        for (int i = down; i >= top; i--) result.add(matrix[i][left]);
        left++;
      }
    }
    return result;
  }
}
