package leetcode.java;

public class StudentAttendanceRecordI_551 {
  public boolean checkRecord(String s) {
    char[] chs = s.toCharArray();
    int numA = 0;
    int numL = 0;
    boolean contThreeL = false;
    for (char c : chs) {
      if (c == 'A') {
        numA++;
      } else if (c == 'L') {
        numL++;
        if (numL == 3) contThreeL = true;
        continue;
      }
      numL = 0;
    }
    return !(numA > 1 || contThreeL);
  }
}
