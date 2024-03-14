package problem.tag.design.easy;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 * <p></p>
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * <p></p>
 */
public class KthLargest {

  private PriorityQueue<Integer> topk;
  private int k;

  public KthLargest(int k, int[] nums) {
    this.topk = new PriorityQueue<>(k + 1);
    this.k = k;

    if (nums.length != 0) {
      for (int i = 0; i < nums.length; i++) {
        topk.offer(nums[i]);
        if (i >= k) {
          topk.poll();
        }
      }
    }
  }

  public int add(int val) {
    topk.offer(val);

    if (topk.size() < k) {
      return topk.peek();
    }

    if (topk.size() > k) {
      topk.poll();
    }
    return topk.peek();
  }

}
