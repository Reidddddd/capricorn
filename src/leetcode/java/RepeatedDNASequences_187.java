package leetcode.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences_187 {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> repeated = new LinkedList<>();
    Set<Integer> firstMatch = new HashSet<>();
    Set<Integer> secondMatch = new HashSet<>();
    char[] chmap = new char[26];
    chmap['A' - 'A'] = 0;
    chmap['C' - 'A'] = 1;
    chmap['G' - 'A'] = 2;
    chmap['T' - 'A'] = 3;
    
    for (int i = 0; i < s.length() - 9; i++) {
      int hash = 0;
      for (int j = i; j < i + 10; j++) {
        hash <<= 2;
        hash |= chmap[s.charAt(j) - 'A'];
      }
      if (!firstMatch.add(hash) && secondMatch.add(hash)) {
        repeated.add(s.substring(i, i + 10));
      }
    }
    return repeated;
  }
}
