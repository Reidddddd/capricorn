package leetcode.java;

public class ConvertANumberToHexadecimal_405 {
  final char[] hexMap = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

  public String toHex(int num) {
    String result = "";
    while (num != 0) {
      result = hexMap[(num & 15)] + result;
      num >>>= 4;
    }
    return result;
  }
}
