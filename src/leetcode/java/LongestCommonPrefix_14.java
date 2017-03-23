package leetcode.java;

public class LongestCommonPrefix_14 {
  public String longestCommonPrefix(String[] strs) {
    int k = strs.length;
    if (k < 1) return "";
    StringBuilder builder = new StringBuilder("");
    String first = strs[0];
    for (int i = 0; i < first.length(); i++) {
      char pre = first.charAt(i);
      for (int j = 0; j < k; j++) {
        if (i >= strs[j].length() || pre != strs[j].charAt(i)) return builder.toString();
      }
      builder.append(pre);
    }
    return builder.toString();
  }
}
