package leetcode.java;

public class ReconstructOriginalDigitsFromEnglish_423 {
  public String originalDigits(String s) {
    int[] counter = new int[10];
    for (char c : s.toCharArray()) {
      switch (c) {
        case 'z': counter[0]++; break;
        case 'w': counter[2]++; break;
        case 'u': counter[4]++; break;
        case 'x': counter[6]++; break;
        case 'g': counter[8]++; break;
        case 's': counter[7]++; break; // c[7] - c[6]
        case 'f': counter[5]++; break; // c[5] - c[4]
        case 'h': counter[3]++; break; // c[3] - c[8]
        case 'o': counter[1]++; break; // c[1] - c[0] - c[2] - c[4]
        case 'i': counter[9]++; break; // c[9] - c[8] - c[6] - c[5]
      }
    }
    counter[7] -= counter[6];
    counter[5] -= counter[4];
    counter[3] -= counter[8];
    counter[1] -= (counter[0] + counter[2] + counter[4]);
    counter[9] -= (counter[8] + counter[6] + counter[5]);
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < counter[i]; j++) {
        builder.append(i);
      }
    }
    return builder.toString();
  }
}
