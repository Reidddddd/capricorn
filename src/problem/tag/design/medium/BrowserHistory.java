package problem.tag.design.medium;

import java.util.Stack;

/**
 * 1472. Design Browser History
 * <p></p>
 * https://leetcode.com/problems/design-browser-history/
 * <p></p>
 */
public class BrowserHistory {

  Stack<String> s1 = new Stack<>();
  Stack<String> s2 = new Stack<>();

  public BrowserHistory(String homepage) {
    s1.push(homepage);
  }

  public void visit(String url) {
    while (!s2.isEmpty()) {
      s2.pop();
    }
    s1.push(url);
  }

  public String back(int steps) {
    while (steps-- > 0 && !s1.isEmpty()) {
      s2.push(s1.pop());
    }
    if (s1.isEmpty()) {
      s1.push(s2.pop());
    }
    return s1.peek();
  }

  public String forward(int steps) {
    while (steps-- > 0 && !s2.isEmpty()) {
      s1.push(s2.pop());
    }
    return s1.peek();
  }

}
