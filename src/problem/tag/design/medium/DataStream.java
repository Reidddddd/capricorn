package problem.tag.design.medium;

/**
 * 2526. Find Consecutive Integers from a Data Stream
 * <p></p>
 * https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/
 * <p></p>
 */
public class DataStream {

  private int value;
  private int limit;
  private int size;

  public DataStream(int value, int k) {
    this.value = value;
    this.limit = k;
    this.size = 0;
  }

  public boolean consec(int num) {
    if (num == value) {
      size++;
    } else {
      size = 0;
    }

    return size >= limit;
  }

}
