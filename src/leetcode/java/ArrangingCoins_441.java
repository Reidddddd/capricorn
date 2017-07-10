package leetcode.java;

public class ArrangingCoins_441 {
  public int arrangeCoins(int n) {
    return (int) ((-1 + Math.sqrt(8 * (long) n + 1)) / 2);
  }
}
