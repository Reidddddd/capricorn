package leetcode.java;

import java.util.Stack;

public class MinStack_155 {
  Stack<Tuple> stack;

  /** initialize your data structure here. */
  public MinStack_155() {
    this.stack = new Stack<>();
  }

  public void push(int x) {
    int min = stack.isEmpty() ? x : Math.min(stack.peek().min, x);
    stack.push(new Tuple(x, min));
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek().value;
  }

  public int getMin() {
    return stack.peek().min;
  }

  private class Tuple {
    int value;
    int min;

    Tuple(int value, int min) {
      this.value = value;
      this.min = min;
    }
  }
}
