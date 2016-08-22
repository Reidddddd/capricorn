package leetcode.java.easy;

public class FirstUniqueCharacterInAString_387 {
  public int firstUniqChar(String s) {
    int[] counter = new int[26];
    char[] carr = s.toCharArray();
    for (char c : carr) counter[c - 'a']++;
    for (int i = 0; i < carr.length; i++) {
      if (counter[carr[i] - 'a'] == 1) return i;
    }
    return -1;
  }
}
