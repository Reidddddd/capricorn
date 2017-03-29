package leetcode.java;

import java.util.HashMap;

public class NextGreaterElementI_496 {
  public int[] nextGreaterElement(int[] findNums, int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) loop1: {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] > nums[i]) {
          map.put(nums[i], nums[j]);
          break loop1;
        }
      }
      map.put(nums[i], -1);
    }
    for (int i = 0; i < findNums.length; i++) findNums[i] = map.get(findNums[i]);
    return findNums;
  }
}
