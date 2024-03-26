package problem.tag.design.medium;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 155. Min Stack
 * <p></p>
 * https://leetcode.com/problems/min-stack/
 * <p></p>
 */
public class MinStack {

  private PriorityQueue<Integer> min;
  private LinkedList<Integer> stack;

  public MinStack() {
    stack = new LinkedList<>();
    min = new PriorityQueue<>();
  }

  public void push(int val) {
    stack.addLast(val);
    min.add(val);
  }

  public void pop() {
    min.remove(stack.removeLast());
  }

  public int top() {
    return stack.getLast();
  }

  public int getMin() {
    return min.peek();
  }

}
