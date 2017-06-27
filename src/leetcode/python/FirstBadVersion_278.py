class FirstBadVersion_278(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        start, end = 1, n
        while start < end:
            mid = start + (end - start) / 2
            if isBadVersion(mid):
                end = mid
            else:
                start = mid + 1
        return mid
