package leetcode.java;

public class RansomNote_383 {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] arr = new int[128];
    for (char c : magazine.toCharArray()) arr[c]++;
    for (char c : ransomNote.toCharArray()) {
      if (--arr[c] < 0) return false;
    }
    return true;
  }
}
