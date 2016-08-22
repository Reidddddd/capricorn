class MaximumProductOfWordLengths_318(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        test = {}
        for w in words:
            temp = 0x0
            for ch in w:
                temp |= (1 << ord(ch) - 97)
            test[temp] = max(test.get(temp, 0), len(w))
        return max([test[x] * test[y] for x in test for y in test if not x & y] or [0])
