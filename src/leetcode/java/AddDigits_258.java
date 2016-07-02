package leetcode.java;

public class AddDigits_258 {
  // Digital root
  public int addDigits(int num) {
    return 1 + (num - 1) % 9;
  }
}
