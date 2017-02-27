class NthDigit_400(object):
    def findNthDigit(self, n):
        """
        :type n: int
        :rtype: int
        """
        ln, bs = 1, 1
        while 9 * ln * bs < n:
            n -= 9 * ln * bs
            bs *= 10
            ln += 1
        ans = 0
        num = (n - 1) // ln + bs
        i = (n - 1) % ln
        while i < ln:
            ans = num % 10
            num //= 10
            i += 1
        return ans
