package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers_386 {
  public List<Integer> lexicalOrder(int n) {
    ArrayList<Integer> res = new ArrayList<>(n);
    generateNum(res, 1, n);
    return res;
  }

  private void generateNum(List<Integer> res, int i, int n) {
    while (i * 10 <= n) {
      res.add(i);
      generateNum(res, i * 10, n);
      i++;
      if (i % 10 == 0) return;
    }
    res.add(i);
    while (++i <= n && i % 10 != 0) res.add(i);
    return;
  }
}
