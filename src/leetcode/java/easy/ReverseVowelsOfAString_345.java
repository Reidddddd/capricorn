package leetcode.java.easy;

public class ReverseVowelsOfAString_345 {
  public String reverseVowels(String s) {
    char[] schar = s.toCharArray();
    int head = 0;
    int tail = schar.length - 1;
    char tmp;
    while (head < tail && head < schar.length && tail >= 0) {
      while (head < schar.length && !isVowel(schar[head])) head++;
      if (head > tail) break;
      while (tail >= 0 && !isVowel(schar[tail])) tail--;
      if (head < tail && tail >= 0 && head < schar.length) {
        tmp = schar[head];
        schar[head] = schar[tail];
        schar[tail] = tmp;
      }
      head++;
      tail--;
    }
    return new String(schar);
  }

  private static boolean isVowel(char check) {
    switch (Character.toLowerCase(check)) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u': return true;
      default: return false;
    }
  }
}
