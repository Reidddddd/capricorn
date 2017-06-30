package leetcode.java;

public class NumberOfSegmentsInAString_434 {
  public int countSegments(String s) {
    s = s.trim().replaceAll(" +", " ");
    return s.equals("") ? 0 : s.split(" ").length;
  }
}
