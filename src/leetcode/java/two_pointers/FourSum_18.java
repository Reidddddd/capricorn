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
}
