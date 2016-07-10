package leetcode.java.two_pointers;

public class RemoveElement_27 {
  public int removeElement(int[] nums, int val) {
    int head = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) nums[head++] = nums[i];
    }
    return head + 1;
  }
}
