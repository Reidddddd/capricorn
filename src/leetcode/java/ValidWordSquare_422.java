package leetcode.java;

import java.util.List;

public class ValidWordSquare_422 {
  public boolean validWordSquare(List<String> words) {
    int row = words.size();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < words.get(i).length(); j++) {
        try {
          if (words.get(i).charAt(j) != words.get(j).charAt(i)) return false;
        } catch (Exception e) {
          return false;
        }
      }
    }
    return true;
  }
}
