package leetcode.java.two_pointers;

import java.util.Arrays;

public class ThreeSumClosest_16 {
  public int threeSumClosest(int[] nums, int target) {
    int closest = nums[0] + nums[1] + nums[2];
    if (nums.length == 3) return closest;
    Arrays.sort(nums);
    int head, tail, sum;
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      head = i + 1;
      tail = nums.length - 1;
      while (head < tail) {
        sum = nums[i] + nums[head] + nums[tail];
        if (sum < target) while (head < tail && nums[++head] == nums[head - 1]);
        else if (sum > target) while (head < tail && nums[--tail] == nums[tail + 1]);
        else return sum;
        if (Math.abs(sum - target) < Math.abs(closest - target)) closest = sum;
      }
    }
    return closest;
  }
}
