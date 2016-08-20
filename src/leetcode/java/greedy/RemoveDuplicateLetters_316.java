package leetcode.java.greedy;

import java.util.Arrays;

public class RemoveDuplicateLetters_316 {
  private static int[] counter = new int[128];

  public String removeDuplicateLetters(String s) {
    if (s.isEmpty()) return "";

    char[] arr = s.toCharArray();
    for (char ch : arr) counter[ch]++;
    int pos = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < arr[pos]) pos = i;
      if (--counter[arr[i]] == 0) break;
    }
    Arrays.fill(counter, 0);
    return arr[pos] + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + arr[pos], ""));
  }
}
