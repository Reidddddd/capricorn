package leetcode.java;

public class NumberOf1Bits_191 {
  public int hammingWeight(int n) {
    int hw = 0, shiftCount = 0;
    while (shiftCount++ < 32) {
      hw += (n & 1);
      n = n >> 1;
    }
    return hw;
  }
}
