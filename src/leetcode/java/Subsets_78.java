package leetcode.java.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
  public List<List<Integer>> subsets(int[] nums) {
    int size = (int) Math.pow(2, nums.length);
    List<List<Integer>> subsets = new ArrayList<>(size);
    subsets.add(Collections.emptyList());
    
    int indexBit;
    for (int i = 1; i < size; i++) {
      indexBit = i;
      List<Integer> set = new LinkedList<>();
      for (int j = 0; j < nums.length; j++) {
        if ((1 & indexBit) == 1) set.add(nums[j]);
        indexBit >>= 1;
      }
      subsets.add(set);
    }
    return subsets;
  }
}
