package leetcode.java.bit_manipulation;

public class CountingBits_338 {
  // Take number X for example, 10011001. 
  // Divide it in 2 parts:
  // <1>.the last digit (1 or 0, which is (i&1), == (i%2) )
  // <2>.the other digits(the number of 1 is f[i >> 1], == f[i/2])
  public int[] countBits(int num) {
    int[] bits = new int [num + 1];
    for (int i = 1; i <= num; i++) {
      bits[i] = bits[i >> 1] + i & 1;
    }
    return bits;
  }
}
