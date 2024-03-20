package problem.tag.design.medium;

import java.util.Arrays;

/**
 * 641. Design Circular Deque
 * <p></p>
 * https://leetcode.com/problems/design-circular-deque/
 * <p></p>
 */
public class MyCircularDeque {

  private int[] values;
  private int head;
  private int tail;
  int count = 0;

  public MyCircularDeque(int k) {
    values = new int[k];
    Arrays.fill(values, -1);
    head = -1;
    tail = -1;
  }

  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    head = moveBackward(head);
    if (tail == -1) {
      tail = head;
    }
    values[head] = value;
    count++;
    return true;
  }

  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    tail = moveForward(tail);
    values[tail] = value;
    count++;
    return true;
  }

  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    values[head] = -1;
    head = moveForward(head);
    count--;
    return true;
  }

  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    values[tail] = -1;
    tail = moveBackward(tail);
    count--;
    return true;
  }

  public int getFront() {
    return head == -1 ? head : values[head];
  }

  public int getRear() {
    return tail == -1 ? tail : values[tail];
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public boolean isFull() {
    return count == values.length;
  }

  private int moveForward(int pointer) {
    pointer++;
    if (pointer >= values.length) {
      pointer = 0;
    }
    return pointer;
  }

  private int moveBackward(int pointer) {
    pointer--;
    if (pointer < 0) {
      pointer = values.length - 1;
    }
    return pointer;
  }

}
