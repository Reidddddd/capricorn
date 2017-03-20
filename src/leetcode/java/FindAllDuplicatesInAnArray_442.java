package leetcode.java;

import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesInAnArray_442 {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new LinkedList<>();
    int temp;
    for (int i = 0; i < nums.length; i++) {
      while (nums[nums[i] - 1] != nums[i]) {
        temp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = temp;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] - 1 != i) res.add(nums[i]);
    }
    return res;
  }
}
