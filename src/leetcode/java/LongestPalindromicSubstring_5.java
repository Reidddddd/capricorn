package leetcode.java;

public class LongestPalindromicSubstring_5 {
  private int start, length;

  public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) return s;
    for (int i = 0; i < s.length(); i++) {
      checkPalindrome(s, i, i);
      checkPalindrome(s, i, i + 1);
    }
    return s.substring(start, start + length);
  }

  private void checkPalindrome(String s, int j, int k) {
    while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
      j--;
      k++;
    }
    if (length < k - j - 1) {
      start = j + 1;
      length = k - j - 1;
    }
  }

  public static void main(String[] args) {
    LongestPalindromicSubstring_5 lps = new LongestPalindromicSubstring_5();
    System.out.println(lps.longestPalindrome("bdbabc"));
  }
}
