package problem.tag.design.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. Design an Ordered Stream
 * <p></p>
 * https://leetcode.com/problems/design-an-ordered-stream/
 * <p></p>
 */
public class OrderedStream {

  private int pointer;
  private String[] values;

  public OrderedStream(int n) {
    this.pointer = 1;
    this.values = new String[n + 1];
  }

  public List<String> insert(int idKey, String value) {
    values[idKey] = value;

    List<String> results = new ArrayList<>();
    int nextPointer = pointer;
    while (nextPointer < values.length && values[nextPointer] != null) {
      results.add(values[nextPointer]);
      nextPointer++;
    }

    pointer = nextPointer;
    return results;
  }

}
