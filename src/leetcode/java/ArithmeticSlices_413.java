package leetcode.java;

public class ArithmeticSlices_413 {
  public int numberOfArithmeticSlices(int[] A) {
    int i = 0, j, res = 0;
    while (i < A.length - 2) {
      if (A[i + 1] - A[i] == A[i + 2] - A[i + 1]) {
        int diff = A[i + 1] - A[i];
        int delta = 1;
        res += delta;
        j = i + 3;
        while (j < A.length && A[j] - A[j - 1] == diff) {
          delta++;
          res += delta;
          j++;
        }
        i = j - 1;
        continue;
      }
      i++;
    }
    return res;
  }

  public static void main(String[] args) {
    ArithmeticSlices_413 as = new ArithmeticSlices_413();
    int[] A = { 1, 2, 3, 4, 7, 10, 13 };
    System.out.println(as.numberOfArithmeticSlices(A));
  }
}
