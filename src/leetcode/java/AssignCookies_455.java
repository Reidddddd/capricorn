package leetcode.java;

import java.util.Arrays;

public class AssignCookies_455 {
  public int findContentChildren(int[] g, int[] s) {
    int res = 0;
    Arrays.sort(g);
    Arrays.sort(s);
    int j = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i] >= g[j]) {
        res++;
        j++;
      }
      if (j >= g.length) break;
    }
    return res;
  }
}
