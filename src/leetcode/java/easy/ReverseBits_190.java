package leetcode.java.easy;

public class ReverseBits_190 {
  public int reverseBits(int n) {
    int res = 0x00000000;
    int shift = 31;
    int bit;
    while (shift >= 0) {
      bit = n & 1;
      n >>= 1;
      if (bit == 1) res |= (1 << shift);
      shift--;
    }
    return res;
  }
}
