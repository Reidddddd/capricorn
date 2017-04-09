package leetcode.java;

public class ReverseWordsInAStringIII_557 {
  public String reverseWords(String s) {
    String[] splits = s.split(" ");
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < splits.length; i++) {
      builder.append(new StringBuilder(splits[i]).reverse().toString());
      if (i == splits.length - 1) break;
      builder.append(" ");
    }
    return builder.toString();
  }
}
