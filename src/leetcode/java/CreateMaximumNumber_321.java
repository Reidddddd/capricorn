package leetcode.java.hard;

public class CreateMaximumNumber_321 {
  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] res = null;
    int[] tmp = null;
    for (int i = 0; i <= k; i++) {
      if (i <= nums1.length && k - i <= nums2.length) {
        tmp = merge(getMaxSublist(nums1, i), getMaxSublist(nums2, k - i));
        res = compareArray(tmp, res);
      }
    }
    return res;
  }

  private int[] compareArray(int[] tmp, int[] res) {
    if (res == null) return tmp;
    int i = 0;
    while (true) {
      if (res[i] > tmp[i]) return res;
      if (tmp[i] > res[i]) return tmp;
      if (++i == res.length) return res;
    }
  }

  private int[] getMaxSublist(int[] nums, int k) {
    int[] sub = new int[k];
    int pos = 0;
    for (int i = 0; i < nums.length; i++) {
      while (pos > 0 && pos + nums.length - i > k && sub[pos - 1] < nums[i]) pos--;
      if (pos < k) sub[pos++] = nums[i];
    }
    return sub;
  }

  private int[] merge(int[] nums1, int[] nums2) {
    int[] res = new int[nums1.length + nums2.length];
    int i = 0, j = 0, k = 0;
    while (i < nums1.length && j < nums2.length) {
      if (compareValue(nums1, i, nums2, j)) res[k++] = nums1[i++];
      else res[k++] = nums2[j++];
    }
    while (i < nums1.length) res[k++] = nums1[i++];
    while (j < nums2.length) res[k++] = nums2[j++];
    return res;
  }

  private boolean compareValue(int[] nums1, int i, int[] nums2, int j) {
    for (; i < nums1.length && j < nums2.length; i++, j++) {
      if (nums1[i] > nums2[j]) return true;
      if (nums1[i] < nums2[j]) return false;
    }
    return i != nums1.length;
  }
}
