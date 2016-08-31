package leetcode.java.medium;

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

  public static void main(String[] args) {
    EliminationGame_390 eg = new EliminationGame_390();
    System.out.println(eg.lastRemaining(18));
  }
}
