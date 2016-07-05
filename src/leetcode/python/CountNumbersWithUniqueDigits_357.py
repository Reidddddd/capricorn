class CountNumbersWithUniqueDigits_357(object):
    def countNumbersWithUniqueDigits(self, n):
        """
        f(0): 1
        f(1): f(0) + 9
        f(2): f(1) + 9 * 9
        f(3): f(2) + 9 * 9 * 8
        f(4): f(3) + 9 * 9 * 8 * 7
        ...
        ...
        ...
        f(i) = f(i - 1)(leading zero) + 9(non-leading zero) * remaining possibility
        """
        if not n:
            return 1
        dp = [0] * (n)
        dp[0] = 9
        for i in range(1, n):
            dp[i] = dp[i - 1] * (10 - i)
        return sum(dp) + 1
