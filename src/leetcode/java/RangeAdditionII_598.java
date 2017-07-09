package leetcode.java;

public class RangeAdditionII_598 {
  public int maxCount(int m, int n, int[][] ops) {
    int min = m;
    int max = n;
    for (int[] row : ops) {
      min = Integer.min(min, row[0]);
      max = Integer.min(max, row[1]);
    }
    return min * max;
  }
}
