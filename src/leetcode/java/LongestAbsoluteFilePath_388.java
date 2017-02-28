package leetcode.java;

public class LongestAbsoluteFilePath_388 {
  public int lengthLongestPath(String input) {
    String[] splits = input.split("\n");
    boolean[] visited = new boolean[splits.length];
    String tab = "\t";
    int maxL = 0;
    for (int i = 0; i < splits.length; i++) {
      if (!splits[i].contains(tab)) {
        if (splits[i].contains(".")) {
          maxL = Math.max(maxL, splits[i].length());
          continue;
        }
        maxL = Math.max(maxL, maxLength(splits, i + 1, tab, splits[i].length(), visited));
      }
    }
    return maxL;
  }

  private int maxLength(String[] splits, int start, String tab, int length, boolean[] visited) {
    int maxL = 0;
    int tmpL;
    for (int i = start; i < splits.length; i++) {
      if (splits[i].contains(tab) && !visited[i]) {
        tmpL = splits[i].length() - tab.length() + 1;
        visited[i] = true;
        if (!splits[i].contains(".")) maxL = Math.max(maxLength(splits, i + 1, tab + "\t", length + tmpL, visited), maxL);
        else maxL = Math.max(length + tmpL, maxL);
      } else if (!visited[i]) break;
    }
    return maxL;
  }
}
