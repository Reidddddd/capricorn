package leetcode.java.easy;

public class MajorityElement_169 {
  public int majorityElement(int[] nums) {
    int cnt = 1;
    int major = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != major) {
        cnt--;
        if (cnt == 0) {
          major = nums[i];
          cnt = 1;
        }
      } else {
        if (++cnt > nums.length / 2) break;
      }
    }
    return major;
  }
}
