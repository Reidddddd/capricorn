class BestTimeToBuyAndSellStock_121(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices or len(prices) == 0:
            return 0
        values = [0] * len(prices)
        for i in range(1, len(prices)):
            values[i] = prices[i] - prices[i-1]
        max_profit, sm = 0, 0
        for i in range(1, len(values)):
            sm += values[i]
            if sm > max_profit:
                max_profit = sm
            elif sm < 0:
                sm = 0
        return max_profit
