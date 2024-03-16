package problem.tag.design.medium;

import java.util.PriorityQueue;

/**
 * 1845. Seat Reservation Manager
 * <p></p>
 * https://leetcode.com/problems/seat-reservation-manager/
 * <p></p>
 */
public class SeatManager {

  private int lowestSeat;
  private PriorityQueue<Integer> unreserve;

  public SeatManager(int n) {
    this.lowestSeat = 1;
    this.unreserve = new PriorityQueue<>();
  }

  public int reserve() {
    if (!unreserve.isEmpty()) {
      return unreserve.poll();
    }

    int result = lowestSeat;
    lowestSeat++;
    return result;
  }

  public void unreserve(int seatNumber) {
    unreserve.add(seatNumber);
  }

}
