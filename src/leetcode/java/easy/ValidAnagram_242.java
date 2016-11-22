package leetcode.java.easy;

public class ValidAnagram_242 {
  public boolean isAnagram(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) return false;
    int[] cnt = new int[26];
    for (char c : s.toCharArray()) cnt[c - 'a'] += 1;
    for (char c : t.toCharArray()) cnt[c - 'a'] -= 1;
    for (int i : cnt) if (i != 0) return false;
    return true;
  }
}
