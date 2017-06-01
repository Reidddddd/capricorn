package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>(numRows);
    for (int i = 0; i < numRows; i++) {
      res.add(new ArrayList<>(i + 1));
    }

    for (int i = 0; i < res.size(); i++) {
      if (i == 0) {
        res.get(i).add(0, 1);
        continue;
      }
      List<Integer> l = res.get(i);
      List<Integer> p = res.get(i - 1);
      l.add(0, 1);
      for (int j = 1; j < i; j++) {
        l.add(j, p.get(j - 1) + p.get(j));
      }
      l.add(i, 1);
    }

    return res;
  }
}
