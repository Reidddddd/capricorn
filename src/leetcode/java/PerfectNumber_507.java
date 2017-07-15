package leetcode.java;

public class PerfectNumber_507 {
  public boolean checkPerfectNumber(int num) {
    if (num == 1) return false;
    int end = (int) Math.sqrt(num);
    int sum = 0;
    for (int start = 2; start <= end; start++) {
      if (num % start == 0) {
        sum += start;
        sum += num / start;
      }
    }
    return ++sum == num;
  }
}
