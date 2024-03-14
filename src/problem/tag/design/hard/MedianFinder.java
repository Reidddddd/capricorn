package problem.tag.design.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 * <p></p>
 * https://leetcode.com/problems/find-median-from-data-stream/
 * <p></p>
 */
public class MedianFinder {

  // In short, the max of left heap + the min of right heap = medium
  // so the idea is to keep smaller number in left max heap, the larger number in right min heap

  private PriorityQueue<Integer> leftMaxHeap;
  private PriorityQueue<Integer> rightMinHeap;
  private boolean even;

  public MedianFinder() {
    leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    rightMinHeap = new PriorityQueue<>();
    even = true;
  }

  public void addNum(int num) {
    if (even) {
      rightMinHeap.offer(num);
      leftMaxHeap.offer(rightMinHeap.poll());
      even = false;
      return;
    }

    leftMaxHeap.offer(num);
    rightMinHeap.offer(leftMaxHeap.poll());
    even = true;
  }

  public double findMedian() {
    if (!even) {
      return leftMaxHeap.peek();
    }

    return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
  }

}
