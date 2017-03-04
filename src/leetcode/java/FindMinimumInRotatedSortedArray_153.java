package leetcode.java;

public class FindMinimumInRotatedSortedArray_153 {
  public int findMin(int[] nums) {
    return min(nums, 0, nums.length - 1);
  }

  private static int min(int[] a, int begin, int end) {
    if (begin > end) return a[0];
    int mid = (end + begin) / 2;
    if (mid > 0 && a[mid - 1] > a[mid]) return a[mid];
    if (mid < a.length - 1 && a[mid] > a[mid + 1]) return a[mid + 1];
    if (a[mid] < a[end]) return min(a, begin, mid - 1);
    return min(a, mid + 1, end);
  }
}
