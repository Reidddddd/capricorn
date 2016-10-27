class Triangle_120(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        row = len(triangle)
        if row == 0:
            return 0
        dp = triangle[-1]
        for i in range(row-2,-1,-1):
            layer = triangle[i]
            for j in range(len(layer)):
                dp[j] = min(dp[j], dp[j+1]) + layer[j]
        return dp[0]
