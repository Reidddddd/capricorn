package leetcode.java;

import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandomO1_380 {
  private HashMap<Integer, Integer> valueToIndex;
  private HashMap<Integer, Integer> indexToValue;
  private Random random;

  /** Initialize your data structure here. */
  public InsertDeleteGetRandomO1_380() {
    this.valueToIndex = new HashMap<>();
    this.indexToValue = new HashMap<>();
    this.random = new Random();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (valueToIndex.containsKey(val)) return false;
    valueToIndex.put(val, indexToValue.size());
    indexToValue.put(indexToValue.size(), val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (valueToIndex.containsKey(val)) {
      int idx = valueToIndex.get(val);
      if (idx != indexToValue.size() - 1) {
        int lastValue = indexToValue.get(indexToValue.size() - 1);
        valueToIndex.put(lastValue, idx);
        indexToValue.put(idx, lastValue);
      }
      valueToIndex.remove(val);
      indexToValue.remove(indexToValue.size() - 1);
      return true;
    }
    return false;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return indexToValue.get(random.nextInt(indexToValue.size()));
  }
}
