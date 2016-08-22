package leetcode.java.easy;

public class ImplementStrStr_28 {
  public int strStr(String haystack, String needle) {
    char[] hay = haystack.toCharArray();
    char[] ned = needle.toCharArray();
    if (hay.length < ned.length) return -1;
    else if (hay.length == 0 || ned.length == 0) return 0;

    for (int i = 0, j = 0, k = 0; i < hay.length - ned.length + 1; i++) {
      if (hay[i] == ned[j]) {
        k = i;
        while (j < ned.length && hay[k] == ned[j]) {
          k++;
          j++;
        }
        if (j == ned.length) return i;
        j = 0;
      }
    }
    return -1;
  }
}
