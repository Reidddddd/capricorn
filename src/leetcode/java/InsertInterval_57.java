package leetcode.java;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval_57 {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> left = new LinkedList<>();
    List<Interval> right = new LinkedList<>();
    if (intervals == null || intervals.isEmpty()) {
      left.add(newInterval);
      return left;
    }
    if (newInterval == null) return intervals;
    int start = newInterval.start, end = newInterval.end;
    for (Interval itv : intervals) {
      if (itv.end < start) {
        left.add(itv);
      } else if (itv.start > end) {
        right.add(itv);
      } else {
        start = Math.min(itv.start, start);
        end = Math.max(itv.end, end);
      }
    }
    left.add(new Interval(start, end));
    left.addAll(right);
    return left;
  }

  class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }
}
