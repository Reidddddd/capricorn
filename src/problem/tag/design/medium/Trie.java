package problem.tag.design.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 208. Implement Trie (Prefix Tree)
 * <p></p>
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * <p></p>
 */
public class Trie {

  private Map<Character, Index> trieTree;
  private Set<String> words;

  public Trie() {
    trieTree = new HashMap<>();
    words = new HashSet<>();
  }

  public void insert(String word) {
    words.add(word);

    char first = word.charAt(0);
    Index index;
    if (trieTree.containsKey(first)) {
      index = trieTree.get(first);
    } else {
      index = new Index();
      trieTree.put(first, index);
    }
    index.addIndex(1, word);
  }

  public boolean search(String word) {
    return words.contains(word);
  }

  public boolean startsWith(String prefix) {
    char first = prefix.charAt(0);
    if (!trieTree.containsKey(first)) {
      return false;
    }

    Index index = trieTree.get(first);
    return index.search(1, prefix);
  }

  class Index {
    Index[] indexes = new Index[26];

    Index() {}

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

    boolean search(int wordIndex, String word) {
      if (wordIndex == word.length()) {
        return true;
      }

      char ch = word.charAt(wordIndex);
      return indexes[ch - 'a'] != null && indexes[ch - 'a'].search(wordIndex + 1, word);
    }
  }

}
