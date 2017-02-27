package leetcode.java.hard;

public class TrappingRainWater_42 {
  public int trap(int[] height) {
    if (height.length > 1) {
      int head = 0;
      int tail = height.length - 1;
      int pt;
      int water = 0;
      while (head < tail) {
        if (height[head] <= height[tail]) {
          pt = head + 1;
          while (pt <= tail && height[pt] < height[head]) {
            water += height[head] - height[pt];
            pt++;
          }
          head = pt;
        } else {
          pt = tail - 1;
          while (pt >= head && height[pt] < height[tail]) {
            water += height[tail] - height[pt];
            pt--;
          }
          tail = pt;
        }
      }
      return water;
    }
    return 0;
  }
}
