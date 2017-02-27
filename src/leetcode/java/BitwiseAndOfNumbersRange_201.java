package leetcode.java.medium;

public class BitwiseAndOfNumbersRange_201 {
  // The approach is to find the leftmost common digits of m and n
  public int rangeBitwiseAnd(int m, int n) {
    if (m == 0) return 0;
    int shift = 0;
    while (m != n) {
      m >>= 1;
      n >>= 1;
      shift++;
    }
    return n << shift;
  }
}
