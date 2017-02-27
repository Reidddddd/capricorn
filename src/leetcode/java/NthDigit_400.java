package leetcode.java.easy;

public class NthDigit_400 {
  public int findNthDigit(int n) {
    int len = 1, base = 1;
    for (; n > 9L * base * len; base *= 10, len++) {
      n -= 9 * base * len;
    }
    int ans = 0, num = (n - 1) / len + base;
    for (int i = (n - 1) % len; i < len; i++) {
      ans = num % 10;
      num /= 10;
    }
    return ans;
  }
}
