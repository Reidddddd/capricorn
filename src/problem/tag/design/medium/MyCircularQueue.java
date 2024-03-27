package problem.tag.design.medium;

import java.util.Arrays;

/**
 * 622. Design Circular Queue
 * <p></p>
 * https://leetcode.com/problems/design-circular-queue/
 * <p></p>
 */
public class MyCircularQueue {

  private int[] queue;
  private int tail;
  private int head;
  int size;

  public MyCircularQueue(int k) {
    queue = new int[k];
    head = 0;
    tail = 0;
    size = 0;
    Arrays.fill(queue, -1);
  }

  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    queue[updateEnqueueIndex()] = value;
    size++;
    return true;
  }

  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }
    queue[updateDequeueIndex()] = -1;
    size--;
    return true;
  }

  public int Front() {
    return isEmpty() ? - 1 : queue[getHeadIndex()];
  }

  public int Rear() {
    return isEmpty() ? -1 : queue[getTailIndex()];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == queue.length;
  }

  private int updateEnqueueIndex() {
    if (tail == queue.length) {
      tail = 0;
    }
    return tail++;
  }

  private int updateDequeueIndex() {
    if (head == queue.length) {
      head = 0;
    }
    return head++;
  }

  private int getTailIndex() {
    return tail == 0 ? queue.length - 1 : tail - 1;
  }

  private int getHeadIndex() {
    return head == queue.length ? 0 : head;
  }

}
