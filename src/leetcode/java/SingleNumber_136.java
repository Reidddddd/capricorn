package leetcode.java;

public class SingleNumber_136 {
  // n ^ n = 0
  // the last value will be the only one
  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      ans ^= nums[i];
    }
    return ans;
  }
}
