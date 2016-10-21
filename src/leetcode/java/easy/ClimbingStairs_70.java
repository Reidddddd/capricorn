package leetcode.java.easy;

public class ClimbingStairs_70 {
  public int climbStairs(int n) {
    int[] steps = new int[n + 1];
    steps[1] = 1;
    if (n < 2) return steps[1];
    steps[2] = 2;
    for (int i = 3; i <= n; i++) {
      steps[i] = steps[i - 1] + steps[i - 2];
    }
    return steps[n];
  }
}
