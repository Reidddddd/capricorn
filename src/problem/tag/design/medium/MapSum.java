package problem.tag.design.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. Map Sum Pairs
 * <p></p>
 * https://leetcode.com/problems/map-sum-pairs/
 * <p></p>
 */
public class MapSum {

  private Map<String, Integer> keyValue;
  private Map<Character, Prefix> prefixMap;

  public MapSum() {
    keyValue = new HashMap<>();
    prefixMap = new HashMap<>();
  }

  public void insert(String key, int val) {
    if (keyValue.containsKey(key)) {
      int oldVal = keyValue.get(key);
      Prefix prefix = prefixMap.get(key.charAt(0));
      prefix.val -= oldVal;
      prefix.val += val;
      prefix.updatePrefix(1, key, oldVal, val);
      keyValue.put(key, val);
      return;
    }

    keyValue.put(key, val);
    Prefix prefix = prefixMap.get(key.charAt(0));
    if (prefix == null) {
      prefix = new Prefix(val);
      prefix.addPrefix(1, key, val);
      prefixMap.put(key.charAt(0), prefix);
      return;
    }

    prefix.val += val;

    prefix.addPrefix(1, key, val);
  }

  public int sum(String prefix) {
    char c = prefix.charAt(0);
    if (!prefixMap.containsKey(c)) {
      return 0;
    }

    Prefix pf = prefixMap.get(c);
    return Math.min(pf.val, pf.sum(1, prefix));
  }

  class Prefix {
    Prefix[] prefixes = new Prefix[26];
    int val;

    Prefix(int val) {
      this.val = val;
    }

    void addPrefix(int index, String prefix, int val) {
      if (index == prefix.length()) {
        return;
      }

      int i = prefix.charAt(index) - 'a';
      Prefix p = prefixes[i];
      if (p == null) {
        p = new Prefix(val);
        prefixes[i] = p;
      } else {
        p.val += val;
      }

      p.addPrefix(index + 1, prefix, val);
    }

    void updatePrefix(int index, String word, int oldVal, int newVal) {
      if (index == word.length()) {
        return;
      }

      int i = word.charAt(index) - 'a';
      Prefix p = prefixes[i];
      p.val -= oldVal;
      p.val += newVal;

      p.updatePrefix(index + 1, word, oldVal, newVal);
    }

    public int sum(int index, String prefix) {
      if (index == prefix.length()) {
        return Integer.MAX_VALUE;
      }

      int i = prefix.charAt(index) - 'a';
      if (prefixes[i] == null) return 0;

      return Math.min(prefixes[i].val, prefixes[i].sum(index + 1, prefix));
    }
  }

}
