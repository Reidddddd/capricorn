package leetcode.java;

public class CanPlaceFlowers_605 {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    boolean planted = false;
    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 0) {
        if (!planted) n--;
        planted = !planted;
      } else {
        if (planted) n++;
        planted = true;
      }
    }
    return n <= 0;
  }
}
