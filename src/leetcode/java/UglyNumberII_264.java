package leetcode.java;

public class UglyNumberII_264 {
  public int nthUglyNumber(int n) {
    int[] ugly = new int[n];
    ugly[0] = 1;
    int u2 = 2, u3 = 3, u5 = 5;
    int i2 = 0, i3 = 0, i5 = 0;
    int minUgly;
    for (int i = 1; i < n; i++) {
      minUgly = Math.min(Math.min(u2, u3), u5);
      ugly[i] = minUgly;
      if (minUgly == u2) u2 = 2 * ugly[++i2];
      if (minUgly == u3) u3 = 3 * ugly[++i3];
      if (minUgly == u5) u5 = 5 * ugly[++i5];
    }
    return ugly[n - 1];
  }
}
