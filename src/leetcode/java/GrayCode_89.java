package leetcode.java.medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {
  public List<Integer> grayCode(int n) {
    List<Integer> res = new ArrayList<>(1 << n);
    for (int i = 0; i < 1 << n; i++) res.add(i ^ (i >> 1));
    return res;
  }
}
