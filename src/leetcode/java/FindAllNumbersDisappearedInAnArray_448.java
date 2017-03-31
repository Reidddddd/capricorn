package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray_448 {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int next, temp;
    for (int i = 0; i < nums.length; i++) {
      next = nums[i] - 1;
      while (next > 0 && nums[next] != -1) {
        temp = next;
        next = nums[next] - 1;
        nums[temp] = -1;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != -1) res.add(i + 1);
    }
    return res;
  }
}
