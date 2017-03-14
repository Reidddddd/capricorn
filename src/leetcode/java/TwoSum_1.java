package leetcode.java;

import java.util.HashMap;

public class TwoSum_1 {
  public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    HashMap<Integer, Integer> index = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int key = target - nums[i];
      if (index.containsKey(nums[i])) {
        res[0] = index.get(nums[i]);
        res[1] = i;
      } else {
        index.put(key, i);
      }
    }
    return res;
  }
}
