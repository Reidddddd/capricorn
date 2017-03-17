package leetcode.java;

public class DetectCapital_520 {
  public boolean detectCapitalUse(String word) {
    return word.matches("[A-Z]*|[A-Z]?[a-z]*");
  }
}
