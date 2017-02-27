class HIndex_274(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        l = len(citations)
        if l == 0:
            return 0
        h = [0] * (l + 1)
        for i in range(l):
            if citations[i] > l:
                h[l] += 1
            else:
                h[citations[i]] += 1
        cnt = 0
        for i in range(l, -1, -1):
            cnt += h[i]
            if cnt >= i:
                return i
        return 0
