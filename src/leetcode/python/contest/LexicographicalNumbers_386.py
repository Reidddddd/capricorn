class LexicographicalNumbers_386(object):
    def lexicalOrder(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        res = list()
        self.generateNum(res, 1, n);
        return res

    def generateNum(self, res, para, n):
        while para * 10 <= n:
            res.append(para)
            self.generateNum(res, para*10, n)
            para += 1
            if para % 10 == 0: return
        res.append(para)
        para += 1
        while para <= n and para % 10 != 0:
            res.append(para)
            para += 1
        return
