package problem.tag.design.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 2349. Design a Number Container System
 * <p></p>
 * https://leetcode.com/problems/design-a-number-container-system/
 * <p></p>
 */
public class NumberContainers {

  private HashMap<Integer, Integer> index2Number;
  private HashMap<Integer, PriorityQueue<Integer>> number2Indexes;
  private HashMap<Integer, HashSet<Integer>> removedIndexes;

  public NumberContainers() {
    index2Number = new HashMap<>();
    number2Indexes = new HashMap<>();
    removedIndexes = new HashMap<>();
  }

  public void change(int index, int number) {
    Integer oldNumber = index2Number.put(index, number);
    if (oldNumber != null) {
      // remove old index from number
      removedIndexes.putIfAbsent(oldNumber, new HashSet<>());
      removedIndexes.putIfAbsent(number, new HashSet<>());
      removedIndexes.get(oldNumber).add(index);
      // remove index from removed, put it back
      removedIndexes.get(number).remove(index);
    }
    // update new index
    number2Indexes.putIfAbsent(number, new PriorityQueue<>());
    number2Indexes.get(number).add(index);
  }

  public int find(int number) {
    if (!number2Indexes.containsKey(number)) {
      return -1;
    }

    PriorityQueue<Integer> indexes = number2Indexes.get(number);
    if (!removedIndexes.containsKey(number)) {
      return indexes.peek();
    }

    HashSet<Integer> removed = removedIndexes.get(number);
    while (removed.contains(indexes.peek())) {
      indexes.poll();
    }
    return indexes.isEmpty() ? -1 : indexes.peek();
  }

}
