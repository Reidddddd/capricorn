package problem.tag.design.medium;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 2336. Smallest Number in Infinite Set
 * <p></p>
 * https://leetcode.com/problems/smallest-number-in-infinite-set/
 * <p></p>
 */
public class SmallestInfiniteSet {

  private HashSet<Integer> smallest;
  private PriorityQueue<Integer> addback;
  private int postive;

  public SmallestInfiniteSet() {
    smallest = new HashSet<>();
    addback = new PriorityQueue<>();
    postive = 1;
  }

  public int popSmallest() {
    if (!addback.isEmpty()) {
      int val = addback.poll();
      smallest.add(val);
      return val;
    }

    int result = postive;
    smallest.add(postive++);
    return result;
  }

  public void addBack(int num) {
    if (smallest.remove(num)) {
      addback.offer(num);
    }
  }

}
