package leetcode.java;

public class BaseballGame_682 {
    public int calPoints(String[] ops) {
        int[] points = new int[ops.length];
        int k = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                points[k] = points[k - 1] + points[k - 2];
                k++;
            } else if (ops[i].equals("D")) {
                points[k] = 2 * points[k - 1];
                k++;
            } else if (ops[i].equals("C")) {
                points[--k] = 0;
            } else {
                points[k++] = Integer.valueOf(ops[i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < k; i++) sum += points[i];
        return sum;
    }
}
