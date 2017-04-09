package leetcode.java;

public class ReverseWordsInAStringIII_557 {
  public String reverseWords(String s) {
    String[] splits = s.split(" ");
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < splits.length; i++) {
      builder.append(reverse(splits[i]));
      if (i == splits.length - 1) break;
      builder.append(" ");
    }
    return builder.toString();
  }

  private String reverse(String word) {
    int len = word.length();
    char[] ch = word.toCharArray();
    char tmp;
    for (int i = 0; i < len / 2; i++) {
      tmp = ch[i];
      ch[i] = ch[len - i - 1];
      ch[len - i - 1] = tmp;
    }
    return new String(ch);
  }
}
