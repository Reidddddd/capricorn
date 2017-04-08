package leetcode.java;

import java.util.Map;
import java.util.TreeMap;

public class RelativeRanks_506 {
  public String[] findRelativeRanks(int[] nums) {
    String[] ranks = new String[nums.length];
    Map<Integer, Integer> m = new TreeMap<>();
    for (int i = 0; i < nums.length; i++) m.put(nums[i], i);
    int i = nums.length;
    for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
      if (i == 3) ranks[entry.getValue()] = "Bronze Medal";
      else if (i == 2) ranks[entry.getValue()] = "Silver Medal";
      else if (i == 1) ranks[entry.getValue()] = "Gold Medal";
      else ranks[entry.getValue()] = String.valueOf(i);
      i--;
    }
    return ranks;
  }
}
