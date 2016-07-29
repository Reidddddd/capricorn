package leetcode.java.two_pointers;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters_3 {
  public int lengthOfLongestSubstring(String s) {
    int max = 0, start = 0;
    int[] asc = new int[256];
    Arrays.fill(asc, -1);
    for (int i = 0; i < s.length(); i++) {
      if (asc[s.charAt(i)] != -1) {
        max = Math.max(max, i - start);
        start = Math.max(start, asc[s.charAt(i)] + 1);
      }
      asc[s.charAt(i)] = i;
    }
    return Math.max(s.length() - start, max);
  }
}
