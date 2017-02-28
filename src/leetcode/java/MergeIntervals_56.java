package leetcode.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals_56 {
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() <= 1) return intervals;
    LinkedList<Interval> merged = new LinkedList<>();
    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.start, o2.start);
      }
    });
    int start = 0, end = 0;
    boolean firstPair = true;
    for (Interval itr : intervals) {
      if (firstPair) {
        start = itr.start;
        end = itr.end;
        firstPair = false;
      } else {
        if (end < itr.start) {
          merged.addLast(new Interval(start, end));
          start = itr.start;
          end = itr.end;
        } else {
          end = Math.max(end, itr.end);
        }
      }
    }
    merged.addLast(new Interval(start, end));
    return merged;
  }

  public class Interval {
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
