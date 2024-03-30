package problem.tag.design.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 981. Time Based Key-Value Store
 * <p></p>
 * https://leetcode.com/problems/time-based-key-value-store/
 * <p></p>
 */
public class TimeMap {

  private HashMap<String, TreeMap<Integer, String>> timeMap;

  public TimeMap() {
    timeMap = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    timeMap.putIfAbsent(key, new TreeMap<>());

    TreeMap<Integer, String> values = timeMap.get(key);
    values.put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    if (!timeMap.containsKey(key)) {
      return "";
    }

    Map.Entry<Integer, String> value = timeMap.get(key).floorEntry(timestamp);
    return value == null ? "" : value.getValue();
  }

}
