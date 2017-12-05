package leetcode.java;

public class ShortestUnsortedContinuousSubarray_581 {
  public int findUnsortedSubarray(int[] nums) {
    int end = -2, start = -1;
    int n = nums.length;
    int min = nums[n - 1], max = nums[0];
    for (int i = 1; i < n; i++) {
      max = Math.max(nums[i], max);
      min = Math.min(nums[n - i - 1], min);
      if (nums[i] < max) end = i;
      if (nums[n - i - 1] > min) start = n - i - 1;
    }
    return end - start + 1;
  }
}
