package leetcode.java.easy;

public class NimGame_292 {
  // if n % 4 != 0, the first just take numbers that equals multiple of 4
  // else lose, for the latter pick can do the same thing to win
  public boolean canWinNim(int n) {
    if (n % 4 == 0) return false;
    return true;
  }
}
