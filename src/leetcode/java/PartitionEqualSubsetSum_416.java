package leetcode.java;

public class PartitionEqualSubsetSum_416 {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum % 2 != 0) return false;
    sum /= 2;
    boolean[] reachable = new boolean[sum + 1];
    reachable[0] = true;
    for (int num : nums) {
      for (int j = sum; j >= num; j--) {
        reachable[j] = reachable[j] || reachable[j - num];
      }
    }
    return reachable[sum];
  }
}
