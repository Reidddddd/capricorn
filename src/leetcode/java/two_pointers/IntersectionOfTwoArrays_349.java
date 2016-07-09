package leetcode.java.two_pointers;

import java.util.HashSet;

public class IntersectionOfTwoArrays_349 {
  // One set stores the larger array, the other set stores the intersection
  // When larger set contains an element of the shorter array, add that to the intersection.
  // Finally, just converts the intersection into array type
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> larger = new HashSet<>();
    HashSet<Integer> inter = new HashSet<>();
    if (nums1.length > nums2.length) {
      return intersection(nums2, nums1, larger, inter);
    }
    return intersection(nums1, nums2, larger, inter);
  }

  private int[] intersection(int[] shorter, int[] longer, HashSet<Integer> larger,
      HashSet<Integer> inter) {
    for (int num : longer)
      larger.add(num);
    for (int num : shorter)
      if (larger.contains(num)) inter.add(num);
    int[] result = new int[inter.size()];
    int i = 0;
    for (int ele : inter)
      result[i++] = ele;
    return result;
  }
}
