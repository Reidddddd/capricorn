package leetcode.java;

import java.util.stream.IntStream;

public class MinimumMovesToEqualArrayElements_453 {
  public int minMoves(int[] nums) {
    return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
  }
}
