package leetcode.java.medium;

public class UTF8Validation_393 {
  public boolean validUtf8(int[] data) {
    int count = 0;
    for (int d : data) {
      if (count == 0) {
        if ((d >> 5) == 0b110) count = 1;
        else if ((d >> 4) == 0b1110) count = 2;
        else if ((d >> 3) == 0b11110) count = 3;
        else if ((d >> 7) == 0b1) return false;
      } else {
        if ((d >> 6) != 0b10) return false;
        count--;
      }
    }
    return count == 0;
  }

  public static void main(String[] args) {
    UTF8Validation_393 ust = new UTF8Validation_393();
    int[] data = { 255 };
    System.out.println(ust.validUtf8(data));
  }
}
