package leetcode.java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams_49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();

    String temp, sorted;
    for (int i = 0; i < strs.length; i++) {
      temp = strs[i];
      char[] ch = temp.toCharArray();
      Arrays.sort(ch);
      sorted = String.valueOf(ch);
      if (map.containsKey(sorted)) {
        map.get(sorted).add(strs[i]);
      } else {
        List<String> each = new LinkedList<>();
        each.add(strs[i]);
        map.put(sorted, each);
      }
    }
    for (List<String> v : map.values()) res.add(v);
    return res;
  }
}
