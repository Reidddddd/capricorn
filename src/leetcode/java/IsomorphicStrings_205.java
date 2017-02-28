package leetcode.java;

public class IsomorphicStrings_205 {
  public boolean isIsomorphic(String s, String t) {
    int[] map = new int[256];
    int[] reverse = new int[256];
    char[] schar = s.toCharArray();
    char[] tchar = t.toCharArray();
    char sc, tc;
    for (int i = 0; i < schar.length; i++) {
      sc = schar[i];
      tc = tchar[i];
      if (map[sc] == 0) {
        if (reverse[tc] != 0) return false;
        map[sc] = tc;
        reverse[tc] = sc;
      } else {
        if (map[sc] != tc) return false;
      }
    }
    return true;
  }
}
