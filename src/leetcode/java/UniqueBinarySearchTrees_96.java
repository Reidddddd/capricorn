package leetcode.java.medium;

public class UniqueBinarySearchTrees_96 {
  public int numTrees(int n) {
    int[] paths = new int[n + 1];
    paths[0] = paths[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = i; j >= 1; j--) {
        paths[i] += paths[j - 1] * paths[i - j];
      }
    }
    return paths[n];
  }
}
