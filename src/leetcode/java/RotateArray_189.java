package leetcode.java;

public class RotateArray_189 {
  public void rotate(int[] nums, int k) {
    if (nums.length < 2) return;
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private void reverse(int[] nums, int i, int j) {
    int tmp;
    while (i < j) {
      tmp = nums[i];
      nums[i++] = nums[j];
      nums[j--] = tmp;
    }
  }
}
