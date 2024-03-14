package problem.tag.design.easy;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * <p></p>
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * <p></p>
 */
public class MyQueue {

  private Stack<Integer> s1;
  private Stack<Integer> s2;

  public MyQueue() {
    s1 = new Stack<>();
    s2 = new Stack<>();
  }

  public void push(int x) {
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
    s1.push(x);
  }

  public int pop() {
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    return s2.pop();
  }

  public int peek() {
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    return s2.peek();
  }

  public boolean empty() {
    return s1.isEmpty() && s2.isEmpty();
  }

}
