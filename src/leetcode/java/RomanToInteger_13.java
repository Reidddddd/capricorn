package leetcode.java;

public class RomanToInteger_13 {
  public int romanToInt(String s) {
    int res = 0;
    int i;
    for (i = 0; i < s.length() - 1; i++) {
      if (roman(s.charAt(i)) < roman(s.charAt(i + 1))) {
        res -= roman(s.charAt(i));
      } else {
        res += roman(s.charAt(i));
      }
    }
    return res + roman(s.charAt(i));
  }

  private static int roman(char c) {
    switch (c) {
      case 'M': return 1000;
      case 'D': return 500;
      case 'C': return 100;
      case 'L': return 50;
      case 'X': return 10;
      case 'V': return 5;
      default: return 1;
    }
  }
}
