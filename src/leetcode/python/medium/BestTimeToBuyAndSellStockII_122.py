class BestTimeToBuyAndSellStockII_122(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int

        more clean version:

            return sum(max(prices[i + 1] - prices[i], 0) for i in range(len(prices) - 1))

        """
        maxprofit = 0
        p_len = len(prices)
        i = 1
        while i < p_len:
            if prices[i] - prices[i - 1] >= 0:
                maxprofit += prices[i] - prices[i - 1]
            i += 1
        return maxprofit
