package leetcode.java;

public class AddStrings_415 {
  public String addStrings(String num1, String num2) {
    StringBuilder sum = new StringBuilder();
    char[] left = num1.length() >= num2.length() ? num1.toCharArray() : num2.toCharArray();
    char[] right = num1.length() < num2.length() ? num1.toCharArray() : num2.toCharArray();
    boolean carry = false;
    int i = right.length - 1;
    int j = left.length - 1;
    for (; i >= 0; i--, j--) carry = addStrings(sum, left[j], right[i], carry);
    for (; j >= 0; j--) carry = addStrings(sum, left[j], '0', carry);
    if (carry) sum.append(1);
    return sum.reverse().toString();
  }

  private static boolean addStrings(StringBuilder sumBuilder, char c, char d, boolean carry) {
    int sum = (c - '0') + (d - '0');
    sum += carry ? 1 : 0;
    sumBuilder.append(sum % 10);
    return sum >= 10;
  }
}
