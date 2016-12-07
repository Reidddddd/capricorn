package leetcode.java.easy;

public class LengthOfLastWord_58 {
  public int lengthOfLastWord(String s) {
    String[] ss = s.split(" ");
    return ss.length == 0 ? 0 : ss[ss.length - 1].length();
  }
}
