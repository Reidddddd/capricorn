package leetcode.java;

import java.util.LinkedList;

public class ValidParentheses_20 {
  public boolean isValid(String s) {
    char[] chs = s.toCharArray();
    LinkedList<Character> stack = new LinkedList<>();
    for (char c : chs) {
      if (stack.isEmpty()) {
        stack.addLast(c);
        continue;
      }
      char p = stack.getLast();
      switch (c) {
        case '}': {
          if (p == '{') stack.removeLast();
          else return false;
          break;
        }
        case ']': {
          if (p == '[') stack.removeLast();
          else return false;
          break;
        }
        case ')': {
          if (p == '(') stack.removeLast();
          else return false;
          break;
        }
        default:
          stack.addLast(c);
          break;
      }
    }
    return stack.isEmpty();
  }
}
