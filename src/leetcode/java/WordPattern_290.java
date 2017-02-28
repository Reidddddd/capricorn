package leetcode.java;

import java.util.HashMap;

public class WordPattern_290 {
  public boolean wordPattern(String pattern, String str) {
    String[] strs = str.split(" ");
    if (pattern.length() != strs.length) return false;
    String[] maps = new String[26];
    HashMap<String, Integer> reverse = new HashMap<>();
    int i = 0;
    for (char c : pattern.toCharArray()) {
      if (!reverse.containsKey(strs[i])) {
        if (maps[c - 'a'] != null && maps[c - 'a'] != strs[i]) return false;
        maps[c - 'a'] = strs[i];
        reverse.put(strs[i], c - 'a');
      } else {
        if (reverse.get(strs[i]) != c - 'a') return false;
      }
      i++;
    }
    return true;
  }
}
