package leetcode.java.hard;

public class MinimumWindowSubstring_76 {
  public String minWindow(String s, String t) {
    if (s.length() < t.length()) return "";
    char[] sc = s.toCharArray();
    char[] tc = t.toCharArray();
    int start = -1;
    int len = Integer.MAX_VALUE;
    int cnt = 0;
    int[] required = new int[256];
    int[] found = new int[256];
    for (char tch : tc) required[tch]++;
    for (int i = 0, j = 0; i < sc.length; i++) {
      if (required[sc[i]] == 0) continue;
      if (++found[sc[i]] <= required[sc[i]]) cnt++;
      if (cnt == tc.length) {
        while (required[sc[j]] == 0 || found[sc[j]] > required[sc[j]]) {
          if (found[sc[j]] > required[sc[j]]) found[sc[j]]--;
          j++;
        }
        if (i - j + 1 < len) {
          start = j;
          len = i - j + 1;
        }
      }
    }
    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }
}
