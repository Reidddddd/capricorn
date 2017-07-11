package leetcode.java;

public class SumOfSquareNumbers_633 {
  public boolean judgeSquareSum(int c) {
    int left = 0, right = (int) Math.sqrt(c);
    while (left <= right) {
      int res = left * left + right * right;
      if (res == c) return true;
      if (res < c) left++;
      else right--;
    }
    return false;
  }
}
