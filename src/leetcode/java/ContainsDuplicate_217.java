package leetcode.java.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> dupli = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
        if (!dupli.add(nums[i])) return true;
    }
    return false;
  }
}
