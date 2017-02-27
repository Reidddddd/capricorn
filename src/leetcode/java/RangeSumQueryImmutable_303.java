package leetcode.java.easy;

public class RangeSumQueryImmutable_303 {
  private int[] nums;

  public RangeSumQueryImmutable_303(int[] nums) {
    for (int i = 1; i < nums.length; i++)
      nums[i] += nums[i - 1];
    this.nums = nums;
  }

  public int sumRange(int i, int j) {
    if (i == 0) return nums[j];
    return nums[j] - nums[i - 1];
  }
}
