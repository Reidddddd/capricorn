class PowerOfThree_326(object):
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n <= 0 and (n & 1) == 0:
            return False
        return n == 1 or n % 3 == 0 and self.isPowerOfThree(n / 3)
