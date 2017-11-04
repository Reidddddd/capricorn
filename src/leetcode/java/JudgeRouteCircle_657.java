package leetcode.java;

public class JudgeRouteCircle_657 {
    public boolean judgeCircle(String moves) {
        int isCircle = 0;
        for (char m : moves.toCharArray()) {
            if (m == 'U') isCircle++;
            else if (m == 'L') isCircle += 2;
            else if (m == 'D') isCircle--;
            else if (m == 'R') isCircle -= 2;
        }
        return isCircle == 0;
    }
}
