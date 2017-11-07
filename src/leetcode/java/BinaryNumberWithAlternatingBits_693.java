package leetcode.java;

public class BinaryNumberWithAlternatingBits_693 {
    public boolean hasAlternatingBits(int n) {
        int pm = -1, m;
        while (n != 0) {
            m = n & 1;
            if (pm == m) return false;
            pm = m;
            n >>= 1;
        }
        return true;
    }
}
