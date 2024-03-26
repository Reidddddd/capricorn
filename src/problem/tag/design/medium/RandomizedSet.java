package problem.tag.design.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 * <p></p>
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * <p></p>
 */
public class RandomizedSet {

  private Map<Integer, Integer> values;
  private Map<Integer, Integer> indexes;
  private Random random;

  public RandomizedSet() {
    values = new HashMap<>();
    indexes = new HashMap<>();
    random = new Random();
  }

  public boolean insert(int val) {
    if (values.containsKey(val)) {
      return false;
    }

    values.put(val, indexes.size());
    indexes.put(indexes.size(), val);
    return true;
  }

  public boolean remove(int val) {
    if (!values.containsKey(val)) {
      return false;
    }

    int i = values.get(val);
    int lastIndex = values.size() - 1;
    if (i != lastIndex) {
      int lastVal = indexes.get(lastIndex);
      values.put(lastVal, i);
      indexes.put(i, lastVal);
    }
    values.remove(val);
    indexes.remove(lastIndex);
    return true;
  }

  public int getRandom() {
    int r = random.nextInt(values.size());
    return indexes.get(r);
  }

}
