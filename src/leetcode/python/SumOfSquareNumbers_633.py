class SumOfSquareNumbers_633(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        import math
        left, right = 0, int(math.sqrt(c))
        while left <= right:
            res = left * left + right * right
            if res == c:
                return True
            if res < c:
                left += 1
            else:
                right -= 1
        return False
