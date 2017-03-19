package leetcode.java;

import java.util.List;

public class WordBreak_139 {
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        dp[i] |= dp[j] && wordDict.contains(s.substring(j, i));
      }
    }
    return dp[s.length()];
  }
}
