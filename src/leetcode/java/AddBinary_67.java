package leetcode.java;

public class AddBinary_67 {
  public String addBinary(String a, String b) {
    char[] left = a.length() >= b.length() ? a.toCharArray() : b.toCharArray();
    char[] right = a.length() < b.length() ? a.toCharArray() : b.toCharArray();
    boolean carry = false;
    int i = left.length - 1, j = right.length - 1;
    StringBuilder res = new StringBuilder();
    for (; j >= 0; j--, i--) carry = binary(left[i], right[j], carry, res);
    for (; i >= 0; i--) carry = binary(left[i], '0', carry, res);
    if (carry) res.append(1);
    return res.reverse().toString();
  }

  private static boolean binary(char c, char d, boolean carry, StringBuilder res) {
    int s = (c - '0') + (d - '0') + (carry ? 1 : 0);
    res.append(s % 2);
    return s >= 2;
  }
}
