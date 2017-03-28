package leetcode.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class KeyboardRow_500 {
  Set<Character> l1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
  Set<Character> l2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
  Set<Character> l3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

  public String[] findWords(String[] words) {
    List<String> res = new LinkedList<>();
    for (String word : words) {
      Set<Character> chs = new HashSet<>();
      for (char c : word.toLowerCase().toCharArray()) chs.add(c);
      if (l1.containsAll(chs) || l2.containsAll(chs) || l3.containsAll(chs)) {
        res.add(word);
      }
    }
    return res.toArray(new String[res.size()]);
  }
}
