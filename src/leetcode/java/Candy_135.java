package leetcode.java.hard;

public class Candy_135 {
  public int candy(int[] ratings) {
    int[] values = new int[ratings.length];
    int[] candies = new int[ratings.length];
    candies[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
      values[i] = ratings[i] - ratings[i - 1];
      candies[i] = 1;
    }

    for (int j = ratings.length - 1; j >= 1; j--) {
      if (values[j] < 0 && candies[j - 1] <= candies[j]) {
        candies[j - 1] = candies[j] + 1;
      }
    }
    int totalCandies = 0;
    for (int k = 1; k < ratings.length; k++) {
      if (values[k] > 0 && candies[k - 1] >= candies[k]) {
        candies[k] = candies[k - 1] + 1;
      }
      totalCandies += candies[k - 1];
    }
    totalCandies += candies[ratings.length - 1];
    return totalCandies;
  }
}
