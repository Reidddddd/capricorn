package leetcode.java.medium;

public class MaximumProductOfWordLengths_318 {
  public int maxProduct(String[] words) {
    int[] wordBits = new int [words.length];
    for (int i = 0; i < wordBits.length; i++) {
      for (char w : words[i].toCharArray()) {
        wordBits[i] |= 1 << (w - 'a');
      }
    }
    
    int maxProduct = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if ((wordBits[i] & wordBits[j]) == 0) {
          maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
        }
      }
    }
    return maxProduct;
  }
}
