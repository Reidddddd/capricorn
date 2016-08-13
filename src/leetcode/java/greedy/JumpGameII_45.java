package leetcode.java.greedy;

public class JumpGameII_45 {
  public int jump(int[] nums) {
    if (nums.length == 1) return 0;

    int cnt = 0, pridx, idx = 0;
    while (true) {
      if (idx + nums[idx] >= nums.length - 1) {
        cnt++;
        break;
      }
      pridx = idx;
      idx = findNextPos(nums, pridx + 1, pridx + nums[pridx]);
      cnt++;
    }
    return cnt;
  }

  private static int findNextPos(int[] nums, int start, int end) {
    int idx = start, max = -1;

    for (int i = end; i >= start; i--) {
      if (i + nums[i] >= nums.length - 1) return i;
      if (i + nums[i] > max) {
        idx = i;
        max = i + nums[i];
      }
    }
    return idx;
  }
}
