package leetcode.java;

public class EliminationGame_390 {
  public int lastRemaining(int n) {
    boolean left = true;
    int step = 1, head = 1;
    int remaining = n;
    while (remaining > 1) {
      if (left || remaining % 2 == 1) head += step;
      left = !left;
      remaining /= 2;
      step *= 2;
    }
    return head;
  }
}
