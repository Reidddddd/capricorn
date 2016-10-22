package leetcode.java.easy;

public class BestTimeToBuyAndSellStock_121 {
  public int maxProfit(int[] prices) {
    if (prices.length == 0 || prices == null) return 0;

    int maxProfit = 0;
    int[] values = new int[prices.length];
    values[0] = 0;
    for (int i = 1; i < prices.length; i++) {
      values[i] = prices[i] - prices[i - 1];
    }

    int sum = 0;
    for (int i = 1; i < values.length; i++) {
      sum += values[i];
      if (sum > maxProfit) maxProfit = sum;
      else if (sum < 0) sum = 0;
    }
    return maxProfit;
  }
}
