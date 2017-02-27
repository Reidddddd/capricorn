package leetcode.java.medium;

public class AddAndSearchWord_211 {
  private Dict root = new Dict();

  // Adds a word into the data structure.
  public void addWord(String word) {
    Dict pt = root;
    int idx;
    for (char c : word.toCharArray()) {
      idx = c - 'a';
      if (pt.dicts[idx] == null) pt.dicts[idx] = new Dict();
      pt = pt.dicts[idx];
    }
    pt.isWord = true;
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    char[] wc = word.toCharArray();
    Dict pt = root;
    for (int i = 0; i < wc.length; i++) {
      if (wc[i] == '.') {
        return nextSearch(pt, wc, i + 1);
      } else {
        int index = wc[i] - 'a';
        if (pt.dicts[index] == null) return false;
        pt = pt.dicts[index];
      }
    }
    return pt.isWord;
  }

  private boolean nextSearch(Dict pointer, char[] wc, int start) {
    Dict p = null;
    for (int j = 0; j < pointer.dicts.length; j++) {
      p = pointer.dicts[j];
      if (p != null) {
        int i;
        for (i = start; i < wc.length; i++) {
          if (wc[i] == '.') {
            if (nextSearch(p, wc, i + 1)) return true;
            else break;
          } else {
            int index = wc[i] - 'a';
            if (p.dicts[index] == null) break;
            p = p.dicts[index];
          }
        }
        if (i == wc.length && p.isWord) return true;
      }
    }
    return false;
  }

  class Dict {
    Dict[] dicts;
    boolean isWord;

    Dict() {
      this.dicts = new Dict[26];
      this.isWord = false;
    }
  }
}
