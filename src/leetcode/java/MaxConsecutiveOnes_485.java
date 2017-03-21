package leetcode.java;

public class MaxConsecutiveOnes_485 {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0, cnt = 0;
    for (int i : nums) {
      if (i == 1) cnt++;
      else {
        max = Math.max(cnt, max);
        cnt = 0;
      }
    }
    return Math.max(cnt, max);
  }
}
