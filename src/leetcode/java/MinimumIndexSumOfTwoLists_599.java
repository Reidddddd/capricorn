package leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists_599 {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> l1 = new HashMap<>();
    Map<String, Integer> common = new HashMap<>();
    for (int i = 0; i < list1.length; i++) l1.put(list1[i], i);
    int min = Integer.MAX_VALUE;
    int val = 0;
    for (int j = 0; j < list2.length; j++) {
      if (l1.containsKey(list2[j])) {
        val = j + l1.get(list2[j]);
        min = Math.min(min, val);
        common.put(list2[j], val);
      }
    }
    List<String> c = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : common.entrySet()) {
      if (entry.getValue() == min) c.add(entry.getKey());
    }
    return c.toArray(new String[c.size()]);
  }
}
