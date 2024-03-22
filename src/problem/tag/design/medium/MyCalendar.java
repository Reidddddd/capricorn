package problem.tag.design.medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * 729. My Calendar I
 * <p></p>
 * https://leetcode.com/problems/my-calendar-i/
 * <p></p>
 */
public class MyCalendar {

  private TreeMap<Integer, Integer> bookSlots;

  public MyCalendar() {
    bookSlots = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    Map.Entry<Integer, Integer> entry = bookSlots.lowerEntry(end);
    if (entry == null || entry.getValue() <= start) {
      bookSlots.put(start, end);
      return true;
    }
    return false;
  }

}
