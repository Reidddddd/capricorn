class UglyNumberII_264(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        ugly = [0] * n
        i2 = i3 = i5 = 0
        u2, u3, u5 = 2, 3, 5
        ugly[0] = 1
        for j in range(1, n):
            min_ugly = min(u2, u3, u5)
            ugly[j] = min_ugly
            if min_ugly == u2:
                i2 += 1
                u2 = 2 * ugly[i2]
            if min_ugly == u3:
                i3 += 1
                u3 = 3 * ugly[i3]
            if min_ugly == u5:
                i5 += 1
                u5 = 5 * ugly[i5]
        return ugly[-1]
