package leetcode.java;

public class ConstructTheRectangle_492 {
  public int[] constructRectangle(int area) {
    int fir = 0, sec = 0;
    int limit = (int) Math.sqrt(area);
    while (area % limit != 0) {
      limit--;
    }
    fir = area / limit;
    sec = limit;
    return new int[] { fir, sec };
  }
}
