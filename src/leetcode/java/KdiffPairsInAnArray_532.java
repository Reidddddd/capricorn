import java.util.HashMap;
import java.util.Map;

public class KdiffPairsInAnArray_532 {
  public int findPairs(int[] nums, int k) {
    if (k < 0) return 0;

    HashMap<Integer, Integer> counter = new HashMap<>();
    for (int n : nums) {
      counter.put(n, counter.getOrDefault(n, 0) + 1);
    }

    int pairs = 0;
    for (Map.Entry<Integer, Integer> e : counter.entrySet()) {
      if (k == 0) {
        if (e.getValue() > 1) pairs++;
      } else {
        if (counter.containsKey(e.getKey() + k)) pairs++;
      }
    }
    return pairs;
  }
}
