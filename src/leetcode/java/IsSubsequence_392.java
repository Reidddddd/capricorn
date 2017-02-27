package leetcode.java.medium;

public class IsSubsequence_392 {
  public boolean isSubsequence(String s, String t) {
    if (s.isEmpty()) return true;
    if (t.isEmpty()) return false;
    char[] arr = s.toCharArray();
    int index = -1;
    for (char ch : arr) {
      index = t.indexOf(ch, index + 1);
      if (index < 0) return false;
    }
    return true;
  }
}
