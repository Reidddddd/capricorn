class ArrangingCoins_441(object):
    def arrangeCoins(self, n):
        """
        :type n: int
        :rtype: int
        """
        from math import sqrt
        return int((sqrt(1 + 8 * n) - 1) / 2)
