package leetcode.java.two_pointers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords_30 {
  public List<Integer> findSubstring(String s, String[] words) {
    HashMap<String, Integer> counter = new HashMap<>();
    for (String word : words) {
      counter.put(word, counter.getOrDefault(word, 0) + 1);
    }

    List<Integer> results = new LinkedList<>();
    int wordLen = words[0].length();
    int wordNum = words.length;
    int sLen = s.length();
    String subStr1;
    String subStr2;
    HashMap<String, Integer> tempCounter;
    for (int i = 0; i < wordLen; i++) {
      tempCounter = (HashMap<String, Integer>) counter.clone();
      int start = i;
      for (int j = i; j < sLen - wordLen + 1; j += wordLen) {
        subStr1 = s.substring(j, j + wordLen);
        tempCounter.put(subStr1, tempCounter.getOrDefault(subStr1, 0) - 1);
        while (tempCounter.getOrDefault(subStr1, 0) < 0) {
          subStr2 = s.substring(start, start + wordLen);
          tempCounter.put(subStr2, tempCounter.getOrDefault(subStr2, 0) + 1);
          start += wordLen;
        }
        if (j + wordLen - start == wordNum * wordLen) {
          results.add(start);
        }
      }
    }
    return results;
  }

  public static void main(String[] args) {
    SubstringWithConcatenationOfAllWords_30 sw = new SubstringWithConcatenationOfAllWords_30();
    String[] words = { "foo", "bar" };
    System.out.println(sw.findSubstring("barfoothefoobarman", words));
  }
}
