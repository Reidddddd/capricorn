package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {
  public List<String> fizzBuzz(int n) {
    int[] multiple = new int[n + 1];
    List<String> res = new ArrayList<>(n);
    int i = 1, j = 1;
    while (i * 3 <= n) multiple[i++ * 3] = 1;
    while (j * 5 <= n) multiple[j++ * 5] = 1;
    for (i = 1; i <= n; i++) {
      if (multiple[i] == 0) res.add(Integer.toString(i));
      else {
        if (i % 3 == 0 && i % 5 == 0) res.add("FizzBuzz");
        else if (i % 5 == 0) res.add("Buzz");
        else res.add("Fizz");
      }
    }
    return res;
  }
}
