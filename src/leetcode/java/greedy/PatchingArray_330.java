package leetcode.java.greedy;

public class PatchingArray_330 {
  public int minPatches(int[] nums, int n) {
    int patch = 0;
    int miss = 1, index = 0, len = nums.length;
    while (miss > 0 && miss <= n) {
      if (index < len && nums[index] <= miss) {
        miss += nums[index++];
      } else {
        miss += miss;
        patch++;
      }
    }
    return patch;
  }
}
