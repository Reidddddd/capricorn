package leetcode.java.greedy;

public class WiggleSubsequence_376 {
  public int wiggleMaxLength(int[] nums) {
    if (nums.length == 0) return 0;

    int length = 1;
    boolean up = false, down = false;
    int previous = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - previous > 0 && !up) {
        while (i < nums.length && nums[i] > nums[i - 1]) {
          i++;
        }
        i--;
        previous = nums[i];
        up = true;
        length++;
        if (up && down) down = false;
      } else if (nums[i] - previous < 0 && !down) {
        while (i < nums.length && nums[i] < nums[i - 1]) {
          i++;
        }
        i--;
        previous = nums[i];
        down = true;
        length++;
        if (up && down) up = false;
      }
    }
    return length;
  }
}
