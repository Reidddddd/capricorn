package leetcode.java;

public class HammingDistance_461 {
  public int hammingDistance(int x, int y) {
    return Integer.bitCount(x ^ y);
  }
}
