package leetcode.java.medium;

public class GasStation_134 {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int start = -1;
    int complete = 0;
    for (int i = 0; i < gas.length; i++) complete += gas[i] - cost[i];
    if (complete < 0) return start;
    int sub = 0;
    start = 0;
    for (int i = 0; i < gas.length; i++) {
      sub += gas[i] - cost[i];
      if (sub < 0) {
        sub = 0;
        start = i + 1;
      }
    }
    return start;
  }
}
