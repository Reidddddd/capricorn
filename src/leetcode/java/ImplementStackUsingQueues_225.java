package leetcode.java;

import java.util.LinkedList;

public class ImplementStackUsingQueues_225 {
  LinkedList<Integer> stack = new LinkedList<>();

  // Push element x onto stack.
  public void push(int x) {
    stack.addLast(x);
  }

  // Removes the element on top of the stack.
  public void pop() {
    stack.removeLast();
  }

  // Get the top element.
  public int top() {
    return stack.getLast();
  }

  // Return whether the stack is empty.
  public boolean empty() {
    return stack.isEmpty();
  }
}
