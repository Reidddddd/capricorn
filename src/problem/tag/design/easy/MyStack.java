package problem.tag.design.easy;

import java.util.LinkedList;

/**
 * 225. Implement Stack using Queues
 * <p></p>
 * https://leetcode.com/problems/implement-stack-using-queues/
 * <p></p>
 */
public class MyStack {

  private final LinkedList<Integer> stack;

  public MyStack() {
    stack = new LinkedList<>();
  }

  public void push(int x) {
    stack.addFirst(x);
  }

  public int pop() {
    return stack.removeFirst();
  }

  public int top() {
    return stack.peekFirst();
  }

  public boolean empty() {
    return stack.isEmpty();
  }

}
