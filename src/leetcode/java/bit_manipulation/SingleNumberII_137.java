package leetcode.java.bit_manipulation;

public class SingleNumberII_137 {
  public int singleNumber(int[] nums) {
    int one = 0x000, two = 0x000;
    for (int i = 0; i < nums.length; i++) {
      one = one ^ nums[i] & ~two;
      two = two ^ nums[i] & ~one;
    }
    return one;
  }
}
