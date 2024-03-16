package problem.tag.design.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1286. Iterator for Combination
 * <p></p>
 * https://leetcode.com/problems/iterator-for-combination/
 * <p></p>
 */
public class CombinationIterator {

  private Iterator<String> iterator;
  private String chars;

  public CombinationIterator(String characters, int combinationLength) {
    this.chars = characters;

    String next = "";
    List<String> results = new ArrayList<>();
    for (int i = 0; i <= chars.length() - combinationLength; i++) {
      nextLevel(results, next + chars.charAt(i), i + 1, combinationLength - 1);
    }

    iterator = results.iterator();
  }

  private void nextLevel(List<String> results, String combination, int nextIndex, int level) {
    if (level == 0) {
      results.add(combination);
      return;
    }

    for (int i = nextIndex; i < chars.length(); i++) {
      nextLevel(results, combination + chars.charAt(i), i + 1, level - 1);
    }
  }

  public String next() {
    return iterator.next();
  }

  public boolean hasNext() {
    return iterator.hasNext();
  }

}
