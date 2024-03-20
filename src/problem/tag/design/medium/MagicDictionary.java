package problem.tag.design.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 676. Implement Magic Dictionary
 * <p></p>
 * https://leetcode.com/problems/implement-magic-dictionary/
 * <p></p>
 */
public class MagicDictionary {

  private Set<String> words;
  private Map<Integer, Set<String>> lenWords;

  public MagicDictionary() {
    words = new HashSet<>();
    lenWords = new HashMap<>();
  }

  public void buildDict(String[] dictionary) {
    for (String s : dictionary) {
      int len = s.length();
      lenWords.putIfAbsent(len, new HashSet<>());
      lenWords.get(len).add(s);
    }
  }

  public boolean search(String searchWord) {
    if (words.contains(searchWord)) {
      return false;
    }

    int len = searchWord.length();
    if (!lenWords.containsKey(len)) {
      return false;
    }

    for (String s : lenWords.get(len)) {
      if (diffOne(s, searchWord)) {
        return true;
      }
    }
    return false;
  }

  private boolean diffOne(String source, String target) {
    int i = 0;
    int diff = 0;
    for (; i < source.length(); i++) {
      if (source.charAt(i) != target.charAt(i)) {
        diff++;
        if (diff > 1) {
          return false;
        }
      }
    }
    return diff == 1;
  }

}
