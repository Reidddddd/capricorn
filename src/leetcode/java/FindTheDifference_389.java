package leetcode.java;

public class FindTheDifference_389 {
  public char findTheDifference(String s, String t) {
    int[] ch = new int[256];
    for (char c : s.toCharArray()) ch[c] += 1;
    char car = '\u0000';
    for (char c : t.toCharArray()) {
      ch[c]--;
      if (ch[c] < 0) {
        car = c;
        break;
      }
    }
    return car;
  }
}
