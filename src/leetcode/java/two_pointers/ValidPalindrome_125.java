package leetcode.java.two_pointers;

public class ValidPalindrome_125 {
  public boolean isPalindrome(String s) {
    if (s.isEmpty() || s.length() == 1) return true;
    char[] ch = s.toCharArray();
    int head = 0, tail = ch.length - 1;
    while (head < tail) {
      while (head < tail &&
          !Character.isLetter(ch[head]) &&
          !Character.isDigit(ch[head]))
        head++;
      while (head < tail &&
          !Character.isLetter(ch[tail]) &&
          !Character.isDigit(ch[tail]))
        tail--;
      if (Character.toLowerCase(ch[head++]) != Character.toLowerCase(ch[tail--])) return false;
    }
    return true;
  }
}
