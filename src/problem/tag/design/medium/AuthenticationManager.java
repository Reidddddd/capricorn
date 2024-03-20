package problem.tag.design.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 1797. Design Authentication Manager
 * <p></p>
 * https://leetcode.com/problems/design-authentication-manager/
 * <p></p>
 */
public class AuthenticationManager {

  private Map<String, Token> tokens;
  private int timeToLive;

  public AuthenticationManager(int timeToLive) {
    tokens = new HashMap<>();
    this.timeToLive = timeToLive;
  }

  public void generate(String tokenId, int currentTime) {
    tokens.put(tokenId, new Token(currentTime, timeToLive));
  }

  public void renew(String tokenId, int currentTime) {
    if (!tokens.containsKey(tokenId)) {
      return;
    }

    Token token = tokens.get(tokenId);
    if (!token.renew(currentTime)) {
      tokens.remove(tokenId);
    }
  }

  public int countUnexpiredTokens(int currentTime) {
    int count = 0;
    Iterator<Map.Entry<String, Token>> it = tokens.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<String, Token> pair = it.next();
      if (pair.getValue().isExpired(currentTime)) {
        it.remove();
        continue;
      }
      count++;
    }
    return count;
  }

  class Token {
    private int expiredTime;
    private int timeToLive;

    Token(int issueTime, int timeToLive) {
      expiredTime = issueTime + timeToLive;
      this.timeToLive = timeToLive;
    }

    boolean isExpired(int currentTime) {
      return currentTime >= expiredTime;
    }

    boolean renew(int currentTime) {
      if (currentTime >= expiredTime) {
        return false;
      }
      expiredTime = currentTime + timeToLive;
      return true;
    }
  }

}
