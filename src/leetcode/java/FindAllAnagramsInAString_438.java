package leetcode.java;

import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString_438 {
  public List<Integer> findAnagrams(String s, String p) {
    LinkedList<Integer> res = new LinkedList<>();
    if (s == null || p == null || s.isEmpty() || p.isEmpty()) return res;

    int[] hash = new int[256];
    for (char c : p.toCharArray()) hash[c]++;
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
      if (hash[s.charAt(right)] > 0) count--;
      hash[s.charAt(right)]--;
      right++;

      if (count == 0) res.addLast(left);

      if (right - left == p.length()) {
        if (hash[s.charAt(left)] >= 0) {
          count++;
        }
        hash[s.charAt(left)]++;
        left++;
      }
    }
    return res;
  }
}
