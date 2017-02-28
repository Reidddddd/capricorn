package leetcode.java;

public class ExcelSheetColumnNumber_171 {
  public int titleToNumber(String s) {
    char[] c = s.toCharArray();
    int res = 0;
    for (int i = c.length - 1, k = 1; i >= 0; i--, k *= 26) {
      res += (c[i] - 'A' + 1) * k;
    }
    return res;
  }
}
