package leetcode.java;

public class SearchInsertPosition_35 {
  public int searchInsert(int[] nums, int target) {
    int len = nums.length;
    for (int i = len - 1; i >= 0; i--) {
      if (nums[i] == target) return i;
      if (nums[i] < target) return i + 1;
    }
    return 0;
  }
}
