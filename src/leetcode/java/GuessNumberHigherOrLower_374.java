package leetcode.java;

public class GuessNumberHigherOrLower_374 {
  public int guessNumber(int n) {
    int h = 1, t = n;
    int m;
    while (h < t) {
      m = h + (t - h) / 2;
      if (guess(m) > 0) {
        h = m + 1;
      } else if (guess(m) < 0) {
        t = m;
      } else {
        h = m;
        break;
      }
    }
    return h;
  }
}
