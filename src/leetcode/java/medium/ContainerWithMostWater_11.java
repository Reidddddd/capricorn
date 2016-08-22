package leetcode.java.medium;

public class ContainerWithMostWater_11 {
  public int maxArea(int[] height) {
    int area = 0;
    int left = 0, right = height.length - 1;
    int high;
    while (left < right) {
      high = Math.min(height[left], height[right]);
      area = Math.max(area, (right - left) * high);
      while (height[left] <= high && left < right) left++;
      while (height[right] <= high && left < right) right--;
    }
    return area;
  }
}
