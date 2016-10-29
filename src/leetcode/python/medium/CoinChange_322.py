class CoinChange_322(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if amount == 0:
            return 0
        dp = [-1] * (amount+1)
        dp[0] = 0
        for c in coins:
            for i in range(c, amount+1):
                if dp[i-c] != -1:
                    if dp[i] == -1:
                        dp[i] = dp[i-c] + 1
                    else:
                        dp[i] = min(dp[i-c]+1, dp[i])
        return dp[amount]
