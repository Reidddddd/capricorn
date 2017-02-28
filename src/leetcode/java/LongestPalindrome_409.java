package leetcode.java;

public class LongestPalindrome_409 {
  public int longestPalindrome(String s) {
    int[] chs = new int[52];
    for (char c : s.toCharArray()) {
      if (Character.isUpperCase(c)) chs[c - 'A' + 26]++;
      else chs[c - 'a']++;
    }
    boolean odd = false;
    int length = 0;
    for (int c : chs) {
      if (c % 2 == 0) length += c;
      else {
        length += (c - 1);
        odd = true;
      }
    }
    return odd ? length + 1 : length;
  }
}
