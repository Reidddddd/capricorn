package problem.tag.design.easy;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 933. Number of Recent Calls
 * <p></p>
 * https://leetcode.com/problems/number-of-recent-calls/
 * <p></p>
 */
public class RecentCounter {

  private LinkedList<Integer> pings;

  public RecentCounter() {
    pings = new LinkedList<>();
  }

  public int ping(int t) {
    pings.add(t);
    int range = t - 3000;
    Iterator<Integer> it = pings.iterator();
    while (it.hasNext()) {
      if (it.next() < range) {
        it.remove();
      }
    }
    return pings.size();
  }

}
