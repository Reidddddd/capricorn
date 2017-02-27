class ConvertANumberToHexadecimal_405(object):
    def toHex(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return '0'
        res, feq = "", 0
        while feq < 8 and num:
            res = "0123456789abcdef"[num & 15] + res
            num >>= 4
            feq += 1
        return res


