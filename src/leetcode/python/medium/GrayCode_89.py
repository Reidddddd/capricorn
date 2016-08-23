class GrayCode_89(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        res = [0] * (1 << n)
        for i in range(len(res)):
            res[i] = i ^ (i >> 1)
        return res
