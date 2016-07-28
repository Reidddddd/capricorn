package leetcode.java.two_pointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum_18 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new LinkedList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; i++) {
      if (nums[i] << 2 > target) break;
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      for (int j = nums.length - 1; j > i + 2; j--) {
        if (nums[j] << 2 < target) break;
        if (j < nums.length - 1 && nums[j] == nums[j + 1]) continue;
        int lo = i + 1, hi = j - 1;
        int re = target - nums[i] - nums[j];
        int sum;
        while (lo < hi) {
          sum = nums[lo] + nums[hi];
          if (sum < re) lo++;
          else if (sum > re) hi--;
          else {
            result.add(Arrays.asList(nums[i], nums[lo], nums[hi], nums[j]));
            while (++lo < hi && nums[lo] == nums[lo - 1]);
            while (lo < --hi && nums[hi] == nums[hi + 1]);
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    FourSum_18 fs = new FourSum_18();
    int[] nums =
        { -497, -494, -484, -477, -453, -453, -444, -442, -428, -420, -401, -393, -392, -381, -357,
            -357, -327, -323, -306, -285, -284, -263, -262, -254, -243, -234, -208, -170, -166,
            -162, -158, -136, -133, -130, -119, -114, -101, -100, -86, -66, -65, -6, 1, 3, 4, 11,
            69, 77, 78, 107, 108, 108, 121, 123, 136, 137, 151, 153, 155, 166, 170, 175, 179, 211,
            230, 251, 255, 266, 288, 306, 308, 310, 314, 321, 322, 331, 333, 334, 347, 349, 356,
            357, 360, 361, 361, 367, 375, 378, 387, 387, 408, 414, 421, 435, 439, 440, 441, 470,
            492 };
    fs.fourSum(nums, 1682);
  }
}
