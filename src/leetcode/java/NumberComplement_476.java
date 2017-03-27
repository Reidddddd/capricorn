package leetcode.java;

public class NumberComplement_476 {
  public int findComplement(int num) {
    int rev = ~num;
    int mask = (Integer.highestOneBit(num) << 1) - 1;
    return rev & mask;
  }
}
