package leetcode.java;

import java.util.HashMap;
 
public class LongestConsecutiveSequence_128 {
  public int longestConsecutive(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int res = 0;
    for (int i : nums) {
      if (!map.containsKey(i)) {
        int left = map.containsKey(i - 1) ? map.get(i - 1) : 0;
        int right = map.containsKey(i + 1) ? map.get(i + 1) : 0;
        int sum = left + right + 1;
        map.put(i, sum);
        res = Math.max(res, sum);
        map.put(i - left, sum);
        map.put(i + right, sum);
      }
    }
    return res;
  }
}
