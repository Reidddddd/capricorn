package problem.tag.design.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 211. Design Add and Search Words Data Structure
 * <p></p>
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 * <p></p>
 */
public class WordDictionary {

  private Map<Integer, Map<Character, Index>> trieTrees;
  private Set<String> words;

  public WordDictionary() {
    words = new HashSet<>();
    trieTrees = new HashMap<>();
  }

  public void addWord(String word) {
    words.add(word);

    trieTrees.putIfAbsent(word.length(), new HashMap<>());

    Map<Character, Index> trieTree = trieTrees.get(word.length());
    char first = word.charAt(0);
    boolean hasKey = trieTree.containsKey(first);

    Index index = hasKey ? trieTree.get(first) : new Index();
    if (!hasKey) trieTree.put(first, index);

    index.addIndex(1, word);
  }

  public boolean search(String word) {
    if (words.contains(word)) return true;

    Map<Character, Index> trieTree = trieTrees.get(word.length());
    if (trieTree == null) return false;

    char c = word.charAt(0);
    if (!trieTree.containsKey(c)) {
      if (c != '.') return false;

      for (Index index : trieTree.values()) {
        if (dfs(word, 1, index)) {
          return true;
        }
      }
      return false;
    }

    Index index = trieTree.get(word.charAt(0));
    return dfs(word, 1, index);
  }

  private boolean dfs(String word, int i, Index index) {
    if (index == null)      return false;
    if (i == word.length()) return true;

    if (word.charAt(i) != '.') {
      Index[] children = index.indexes;
      int childIndex = word.charAt(i) - 'a';
      return children[childIndex] != null && dfs(word, i + 1, children[childIndex]);
    }

    // else, word.charAt(i) == '.', need to iterate all non-null index
    for (Index child : index.indexes) {
      if (dfs(word, i + 1, child)) {
        return true;
      }
    }
    return false;
  }

  class Index {
    Index[] indexes = new Index[26];

    void addIndex(int wordIndex, String word) {
      if (wordIndex == word.length()) {
        return;
      }

      char ch = word.charAt(wordIndex);
      Index index = indexes[ch - 'a'];
      if (index == null) {
        index = new Index();
        indexes[ch - 'a'] = index;
      }
      index.addIndex(wordIndex + 1, word);
    }
  }

}
