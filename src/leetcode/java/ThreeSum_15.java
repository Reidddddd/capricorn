package leetcode.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum_15 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new LinkedList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) break;
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int lo = i + 1, hi = nums.length - 1;
      int sum;
      while (lo < hi) {
        sum = nums[lo] + nums[hi];
        if (sum < -nums[i]) lo++;
        else if (sum > -nums[i]) hi--;
        else {
          result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
          while (++lo < hi && nums[lo] == nums[lo - 1]);
          while (lo < --hi && nums[hi] == nums[hi + 1]);
        }
      }
    }
    return result;
  }
}
