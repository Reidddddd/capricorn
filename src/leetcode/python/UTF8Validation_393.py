class UTF8Validation_393(object):
    def validUtf8(self, data):
        """
        :type data: List[int]
        :rtype: bool
        """
        c = 0
        for d in data:
            if c == 0:
                if d >> 5 == 0b110:
                    c = 1
                elif d >> 4 == 0b1110:
                    c = 2
                elif d >> 3 == 0b11110:
                    c = 3
                elif d >> 7 == 0b1:
                    return False
            else:
                if d >> 6 != 0b10: return False
                c -= 1
        return c == 0
