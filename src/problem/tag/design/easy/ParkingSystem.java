package problem.tag.design.easy;

/**
 * 1603. Design Parking System
 * <p></p>
 * https://leetcode.com/problems/design-parking-system/
 * <p></p>
 */
public class ParkingSystem {

  private int big;
  private int medium;
  private int small;

  public ParkingSystem(int big, int medium, int small) {
    this.big = big;
    this.medium = medium;
    this.small = small;
  }

  public boolean addCar(int carType) {
    if (carType == 1 && big-- > 0) {
      return true;
    }
    if (carType == 2 && medium-- > 0) {
      return true;
    }
    if (carType == 3 && small-- > 0) {
      return true;
    }
    return false;
  }

}
