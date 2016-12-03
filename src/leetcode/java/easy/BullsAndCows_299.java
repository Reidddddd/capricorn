package leetcode.java.easy;

public class BullsAndCows_299 {
  public String getHint(String secret, String guess) {
    int[] buckets = new int[10];
    int a = 0, b = 0;
    for (char cs : secret.toCharArray()) buckets[cs - '0']++;
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) a++;
      if (buckets[guess.charAt(i) - '0'] > 0) {
        System.out.println(guess.charAt(i));
        b++;
        buckets[guess.charAt(i) - '0']--;
      }
    }
    return a + "A" + (b - a) + "B";
  }
}
