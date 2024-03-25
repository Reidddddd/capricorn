package problem.tag.design.medium;

/**
 * 2424. Longest Uploaded Prefix
 * <p></p>
 * https://leetcode.com/problems/longest-uploaded-prefix/
 * <p></p>
 */
public class LUPrefix {

  private boolean[] uploaded;
  private int prefix;

  public LUPrefix(int n) {
    uploaded = new boolean[n + 1];
    uploaded[0] = true;
    prefix = 0;
  }

  public void upload(int video) {
    uploaded[video] = true;
    while (prefix < uploaded.length && uploaded[prefix]) {
      prefix++;
    }
    prefix--;
  }

  public int longest() {
    return prefix;
  }

}
