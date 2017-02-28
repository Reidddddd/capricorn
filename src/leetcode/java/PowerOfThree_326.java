package leetcode.java;

public class PowerOfThree_326 {
  public boolean isPowerOfThree(int n) {
    if (n <= 0 || (n & 1) == 0) return false;
    return (n == 1 || n % 3 == 0 && isPowerOfThree(n / 3));
  }
}
