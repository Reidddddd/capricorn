class ExcelSheetColumnNumber_171(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        res, k = 0, 1
        s = s[::-1]
        for c in s:
            res += (ord(c) - 64) * k
            k *= 26
        return res
