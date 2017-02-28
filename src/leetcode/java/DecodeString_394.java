package leetcode.java;

import java.util.Stack;

public class DecodeString_394 {
  public String decodeString(String s) {
    Stack<Integer> fre = new Stack<>();
    Stack<String> res = new Stack<>();
    res.push("");
    for (int i = 0; i < s.length(); i++) {
      if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
        int j = i;
        while ('0' <= s.charAt(i + 1) && s.charAt(i + 1) <= '9') i++;
        fre.push(Integer.valueOf(s.substring(j, i + 1)));
      } else if (s.charAt(i) == '[') {
        res.push("");
      } else if (s.charAt(i) == ']') {
        int freq = fre.pop();
        String sub = res.pop();
        StringBuilder bd = new StringBuilder();
        for (int j = 0; j < freq; j++) bd.append(sub);
        res.push(res.pop() + bd.toString());
      } else {
        res.push(res.pop() + s.charAt(i));
      }
    }
    return res.pop();
  }
}
