package leetcode.java;

public class TwoSumII_167 {
  public int[] twoSum(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      if (target < nums[lo] + nums[hi]) hi--;
      else if (target > nums[lo] + nums[hi]) lo++;
      else break;
    }
    return new int[] { lo + 1, hi + 1 };
  }
}
