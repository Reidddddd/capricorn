package leetcode.java;

import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;

public class InsertDeleteGetRandomO1DuplicatesAllowed_381 {
  private HashMap<Integer, TreeSet<Integer>> value;
  private HashMap<Integer, Integer> index;
  private Random random;

  /** Initialize your data structure here. */
  public InsertDeleteGetRandomO1DuplicatesAllowed_381() {
    this.value = new HashMap<>();
    this.index = new HashMap<>();
    this.random = new Random();
  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the
   * specified element.
   */
  public boolean insert(int val) {
    boolean contain = value.containsKey(val);
    if (!contain) value.put(val, new TreeSet<>());
    TreeSet<Integer> idxSet = value.get(val);
    idxSet.add(index.size());
    index.put(index.size(), val);
    return !contain;
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified
   * element.
   */
  public boolean remove(int val) {
    if (!value.containsKey(val)) return false;
    TreeSet<Integer> idxSet = value.get(val);
    int idx = idxSet.pollLast();
    if (idxSet.size() == 0) value.remove(val);
    int exchangeKey = index.get(index.size() - 1);
    if (exchangeKey == val) {
      index.remove(index.size() - 1);
      return true;
    }
    int exchangeidx = value.get(exchangeKey).pollLast();
    index.put(idx, exchangeKey);
    value.get(exchangeKey).add(idx);
    index.remove(exchangeidx);
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    return index.get(random.nextInt(index.size()));
  }
}
