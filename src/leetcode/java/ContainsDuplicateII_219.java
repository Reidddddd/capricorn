package leetcode.java;

import java.util.HashSet;

public class ContainsDuplicateII_219 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > k) set.remove(nums[i - k - 1]);
      if (!set.add(nums[i])) return true;
    }
    return false;
  }
}
