package leetcode.java.easy;

public class ValidSudoku_36 {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      if (!isValidRow(board[i])) return false;
    }
    for (int i = 0; i < 9; i++) {
      if (!isValidColumn(board, i)) return false;
    }
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        if (!isValidNine(board, i, j)) return false;
      }
    }
    return true;
  }

  private boolean isValidNine(char[][] board, int i, int j) {
    int[] hash = new int[10];
    int idx = 0;
    for (int k = i; k < i + 3; k++) {
      for (int h = j; h < j + 3; h++) {
        idx = board[k][h] - '0';
        if (idx < 0) continue;
        if (hash[idx] != 0) return false;
        hash[idx]++;
      }
    }
    return true;
  }

  private boolean isValidColumn(char[][] board, int col) {
    int[] hash = new int[10];
    int idx = 0;
    for (int i = 0; i < 9; i++) {
      idx = board[i][col] - '0';
      if (idx < 0) continue;
      if (hash[idx] != 0) return false;
      hash[idx]++;
    }
    return true;
  }

  private boolean isValidRow(char[] cs) {
    int[] hash = new int[10];
    int idx = 0;
    for (int i = 0; i < 9; i++) {
      idx = cs[i] - '0';
      if (idx < 0) continue;
      if (hash[idx] != 0) return false;
      hash[idx]++;
    }
    return true;
  }
}
