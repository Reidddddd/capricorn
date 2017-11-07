class BinaryNumberWithAlternatingBits_693(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        pm = -1
        while n:
            m = n & 1
            if pm == m:
                return False
            pm = m
            n >>= 1
        return True
