package problem.tag.design.medium;

import java.util.LinkedList;

/**
 * 1670. Design Front Middle Back Queue
 * <p></p>
 * https://leetcode.com/problems/design-front-middle-back-queue/
 * <p></p>
 */
public class FrontMiddleBackQueue {

  private LinkedList<Integer> frontList;
  private LinkedList<Integer> backList;
  private boolean even;

  public FrontMiddleBackQueue() {
    frontList = new LinkedList<>();
    backList = new LinkedList<>();
    even = true;
  }

  public void pushFront(int val) {
    addFirst(frontList, val);
    if (even) {
      addFirst(backList, removeLast(frontList));
    }
    even = !even;
  }

  public void pushMiddle(int val) {
    if (even) {
      addFirst(backList, val);
    } else {
      addLast(frontList, val);
    }
    even = !even;
  }

  public void pushBack(int val) {
    addLast(backList, val);
    if (!even) {
      addLast(frontList, removeFirst(backList));
    }
    even = !even;
  }

  public int popFront() {
    if (!even) {
      addLast(frontList, removeFirst(backList));
    }
    int res = removeFirst(frontList);
    if (res != -1) {
      even = !even;
    }
    return res;
  }

  public int popMiddle() {
    int res = even ? removeLast(frontList) : removeFirst(backList);
    if (res != -1) {
      even = !even;
    }
    return res;
  }

  public int popBack() {
    if (even) {
      addFirst(backList, removeLast(frontList));
    }
    int res = removeLast(backList);
    if (res != -1) {
      even = !even;
    }
    return res;
  }

  private int removeLast(LinkedList<Integer> list) {
    return list.isEmpty() ? -1 : list.removeLast();
  }

  private int removeFirst(LinkedList<Integer> list) {
    return list.isEmpty() ? -1 : list.removeFirst();
  }

  private void addFirst(LinkedList<Integer> list, int val) {
    if (val == -1) return;
    list.addFirst(val);
  }

  private void addLast(LinkedList<Integer> list, int val) {
    if (val == -1) return;
    list.addLast(val);
  }

}
