package leetcode.java.medium;

public class JumpGame_55 {
  public boolean canJump(int[] nums) {
    if (nums.length == 1) return true;

    int maxPos = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0 && i > maxPos) break;
      maxPos = Math.max(i + nums[i], maxPos);
      if (maxPos >= nums.length - 1) return true;
    }
    return false;
  }
}
