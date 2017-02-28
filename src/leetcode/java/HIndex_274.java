package leetcode.java;

public class HIndex_274 {
  public int hIndex(int[] citations) {
    int length = citations.length;
    if (length == 0) return 0;
    int[] h = new int[length + 1];
    for (int i = 0; i < length; i++) {
      if (citations[i] > length) h[length]++;
      else h[citations[i]]++;
    }
    int cnt = 0;
    for (int i = length; i >= 0; i--) {
      cnt += h[i];
      if (cnt >= i) return i;
    }
    return 0;
  }
}
