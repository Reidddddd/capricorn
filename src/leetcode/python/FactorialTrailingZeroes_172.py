class FactorialTrailingZeroes_172(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 0
        res = 0
        while n % 5 == 0 or n / 5 == 0:
            n /= 5
            res += n
        return res
