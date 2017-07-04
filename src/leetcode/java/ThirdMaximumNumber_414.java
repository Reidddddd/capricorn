package leetcode.java;

import java.util.Arrays;

public class ThirdMaximumNumber_414 {
  public int thirdMax(int[] nums) {
    int[] s = new int[3];
    s[0] = nums[0];
    boolean unsorted = true;
    for (int i = 1, k = 1; i < nums.length; i++) {
      if (unsorted) {
        if (k == 1 && nums[i] != s[0]) {
          s[k++] = nums[i];
        } else if (k == 2 && nums[i] != s[0] && nums[i] != s[1]) {
          s[k] = nums[i];
          Arrays.sort(s);
          unsorted = false;
        }
      } else {
        if (nums[i] == s[0] || nums[i] == s[1] || nums[i] == s[2]) continue;
        if (nums[i] > s[2]) {
          s[0] = s[1];
          s[1] = s[2];
          s[2] = nums[i];
        } else if (nums[i] > s[1]) {
          s[0] = s[1];
          s[1] = nums[i];
        } else if (nums[i] > s[0]) {
          s[0] = nums[i];
        }
      }
    }
    return unsorted ? Math.max(s[0], s[1]) : s[0];
  }
}
