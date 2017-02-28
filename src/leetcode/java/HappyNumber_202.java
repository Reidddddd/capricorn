package leetcode.java;

public class HappyNumber_202 {
  public boolean isHappy(int n) {
    int slow = n, fast = n;
    do {
      slow = calculate(slow);
      fast = calculate(calculate(fast));
      if (fast == 1) return true;
    } while (slow != fast);
    return false;
  }

  private int calculate(int n) {
    int res = 0, tmp;
    while (n > 0) {
      tmp = n % 10;
      res += tmp * tmp;
      n /= 10;
    }
    return res;
  }
}
