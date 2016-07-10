package leetcode.java.two_pointers;

public class SortColors_75 {
  public void sortColors(int[] nums) {
    if (nums.length == 0 || nums.length == 1) return;
    int zeroPos = 0;
    int twoPos = nums.length - 1;
    for (int i = 0; i <= twoPos; i++) {
      while (nums[i] == 2 && i < twoPos) swap(nums, twoPos--, i);
      while (nums[i] == 0 && i > zeroPos) swap(nums, zeroPos++, i);
    }
  }

  private static void swap(int[] nums, int index1, int index2) {
    int tmp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = tmp;
  }
}
