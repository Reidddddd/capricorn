package leetcode.java;

public class SumOfTwoIntegers_371 {
  // xor op: get the sum without carry
  // and op: get the carry
  // shift left carry 1 bit
  // We will get the result if carry is zero.
  public int getSum(int a, int b) {
    if (a == 0) return b;
    if (b == 0) return a;

    int carry;
    while (b != 0) {
      carry = a & b;
      a = a ^ b;
      b = carry << 1;
    }
    return a;
  }
}
