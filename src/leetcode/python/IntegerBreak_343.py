class IntegerBreak_343(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [0] * (n+1)
        dp[1] = 1
        for i in range(2, n+1):
            point = i // 2
            dp[i] = max(max(dp[point], point) * max(dp[i-point], i-point),
                        max(dp[point-1], point-1) * max(dp[i-point+1], i-point+1))
        return dp[n]
