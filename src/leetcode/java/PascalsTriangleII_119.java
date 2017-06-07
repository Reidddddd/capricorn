package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_119 {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<>(rowIndex + 1);
    for (int i = 0; i <= rowIndex; i++) res.add(0);
    res.set(0, 1);
    for (int i = 1; i <= rowIndex; i++) {
      for (int j = i; j > 0; j--) {
        res.set(j, res.get(j - 1) + res.get(j));
      }
    }
    return res;
  }
}
