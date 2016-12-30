package leetcode.java.medium;

import java.util.Arrays;

public class LargestNumber_179 {
  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0) return "";
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++)
      strs[i] = nums[i] + "";
    Arrays.sort(strs, (a, b) -> ((a + b).compareTo(b + a))); 
    StringBuilder builder = new StringBuilder();
    for (int i = strs.length - 1; i >= 0; i--)
      builder.append(strs[i]);
    String res = builder.toString();
    if (res.charAt(0) == '0') return "0";
    return res;
  }
}
