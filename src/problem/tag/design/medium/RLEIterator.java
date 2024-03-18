package problem.tag.design.medium;

/**
 * 900. RLE Iterator
 * <p></p>
 * https://leetcode.com/problems/rle-iterator/
 * <p></p>
 */
public class RLEIterator {

  private int[] encoding;
  private long stepped;
  private long total;
  private int currentIndex;

  public RLEIterator(int[] encoding) {
    currentIndex = 0;
    stepped = 0;
    total = encoding[0];
    this.encoding = encoding;
  }

  public int next(int n) {
    if (currentIndex >= encoding.length) {
      return -1;
    }

    stepped += n;
    if (stepped <= total) {
      return encoding[currentIndex + 1];
    }

    while (total < stepped) {
      currentIndex += 2;
      if (currentIndex >= encoding.length) return -1;
      if (encoding[currentIndex] == 0) continue;
      total += encoding[currentIndex];
    }
    return encoding[currentIndex + 1];
  }

}
