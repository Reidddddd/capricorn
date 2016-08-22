package leetcode.java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements_347 {
  // 1. Sort the array
  // 2. Traverse the array to make tuple (key, frequency)
  // 3. Add the tuple to priority queue which is sorted by value
  // 4. Retrieve the top k from queue and add to the result list
  public List<Integer> topKFrequent(int[] nums, int k) {
    PriorityQueue<Tuple> queue = new PriorityQueue<>(k, new Comparator<Tuple>() {
      @Override
      public int compare(Tuple o1, Tuple o2) {
        if (o2.getFrequency() > o1.getFrequency()) return 1;
        else if (o1.getFrequency() == o2.getFrequency()) return 0;
        return -1;
      }
    });

    Arrays.sort(nums);

    int frequency = 1;
    int key = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        queue.add(new Tuple(key, frequency));
        key = nums[i];
        frequency = 1;
      } else frequency++;
    }
    queue.add(new Tuple(key, frequency));

    List<Integer> result = new ArrayList<>(k);
    int cnt = 0;
    do {
      result.add(queue.poll().getKey());
    } while (++cnt < k);
    return result;
  }

  static class Tuple {
    int key;
    int frequency;

    Tuple(int key, int frequency) {
      this.key = key;
      this.frequency = frequency;
    }

    public int getKey() {
      return key;
    }

    public int getFrequency() {
      return frequency;
    }
  }
}
