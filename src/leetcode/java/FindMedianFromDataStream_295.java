package leetcode.java;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream_295 {
  private PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
  private PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
  boolean even = true;

  // Adds a number into the data structure.
  public void addNum(int num) {
    if (even) {
      rightHeap.offer(num);
      leftHeap.offer(rightHeap.poll());
    } else {
      leftHeap.offer(num);
      rightHeap.offer(leftHeap.poll());
    }
    even = !even;
  }

  // Returns the median of current data stream
  public double findMedian() {
    if (even) {
      return (double) (leftHeap.peek() + rightHeap.peek()) / 2;
    }
    return leftHeap.peek();
  }
}
