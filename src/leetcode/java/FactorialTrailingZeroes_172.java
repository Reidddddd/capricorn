package leetcode.java;

public class FactorialTrailingZeroes_172 {
  public int trailingZeroes(int n) {
    if (n == 0) return 0;
    int res = 0;
    while (n % 5 == 0 || n / 5 != 0) {
      n /= 5;
      res += n;
    }
    return res;
  }
}
