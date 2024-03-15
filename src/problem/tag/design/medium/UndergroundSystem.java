package problem.tag.design.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 1396. Design Underground System
 * <p></p>
 * https://leetcode.com/problems/design-underground-system/
 * <p></p>
 */
public class UndergroundSystem {

  private Map<Integer, String> id2Src;
  private Map<Integer, Integer> id2StartTime;
  private Map<Distance, Distance> distanceCount;

  public UndergroundSystem() {
    id2Src = new HashMap<>();
    id2StartTime = new HashMap<>();
    distanceCount = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    id2Src.put(id, stationName);
    id2StartTime.put(id, t);
  }

  public void checkOut(int id, String stationName, int t) {
    String src = id2Src.remove(id);
    int endTime = id2StartTime.remove(id);

    Distance distance = new Distance(src, stationName);
    if (distanceCount.containsKey(distance)) {
      distanceCount.get(distance).updateInterval(t - endTime);
    } else {
      distance.updateInterval(t - endTime);
      distanceCount.put(distance, distance);
    }
  }

  public double getAverageTime(String startStation, String endStation) {
    return distanceCount.get(new Distance(startStation, endStation)).getAverage();
  }

  class Distance {
    String src;
    String dst;
    int interval;
    int count;

    Distance(String src, String dst) {
      this.src = src;
      this.dst = dst;
      this.interval = 0;
      this.count = 0;
    }

    void updateInterval(int interval) {
      this.count++;
      this.interval += interval;
    }

    double getAverage() {
      return (double) interval / count;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(src + dst);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Distance) {
        Distance other = (Distance) obj;
        return other.src.equals(this.src) && other.dst.equals(this.dst);
      }
      return false;
    }
  }

}
