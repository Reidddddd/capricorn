package leetcode.java.medium;

public class ImplementTrie_208 {
  private TrieNode root;

  public ImplementTrie_208() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    char[] arr = word.toCharArray();
    int childIndex;
    TrieNode pt = root;
    for (int idx = 0; idx < arr.length; idx++) {
      childIndex = arr[idx] - 'a';
      if (pt.children[childIndex] == null) {
        pt.children[childIndex] = new TrieNode();
      }
      pt = pt.children[childIndex];
    }
    pt.isWord = true;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    return search(word, true);
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    return search(prefix, false);
  }

  private boolean search(String word, boolean whole) {
    char[] arr = word.toCharArray();
    int childIndex;
    TrieNode pt = root;
    for (int idx = 0; idx < arr.length; idx++) {
      childIndex = arr[idx] - 'a';
      if (pt.children[childIndex] == null) return false;
      pt = pt.children[childIndex];
    }
    return whole ? pt.isWord : true;
  }

  class TrieNode {
    TrieNode[] children;
    boolean isWord;

    // Initialize your data structure here.
    public TrieNode() {
      this.children = new TrieNode[26];
      this.isWord = false;
    }
  }
}
