package leetcode.java;

public class ReverseString_344 {
  // First, convert the string to char array schar[].
  // Second, swap (schar[0], schar[length - 1]),
  // (schar[1], schar[length - 2]) and so on.
  public String reverseString(String s) {
    char[] schars = s.toCharArray();
    char tmp;
    for (int i = 0; i < schars.length / 2; i++) {
      tmp = schars[i];
      schars[i] = schars[schars.length - i - 1];
      schars[schars.length - i - 1] = tmp;
    }
    return new String(schars);
  }
}
