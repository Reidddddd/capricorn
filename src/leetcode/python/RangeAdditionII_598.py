class RangeAdditionII_598(object):
    def maxCount(self, m, n, ops):
        """
        :type m: int
        :type n: int
        :type ops: List[List[int]]
        :rtype: int
        """
        mn, mx = m, n
        for r in ops:
            mn = min(mn, r[0])
            mx = min(mx, r[1])
        return mn * mx
