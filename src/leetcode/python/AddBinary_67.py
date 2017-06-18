class AddBinary_67(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        if len(a) < len(b):
            a, b = b, a
        res = []

        def binary(l, r, c):
            s = int(l) + int(r) + (1 if c else 0)
            res.append(str(s % 2))
            return s >= 2

        bl, br = len(a) - 1, len(b) - 1
        c = False
        while br >= 0:
            c = binary(a[bl], b[br], c)
            bl, br = bl - 1, br - 1
        while bl >= 0:
            c = binary(a[bl], '0', c)
            bl -= 1
        if c:
            res.append("1")
        return ''.join(res[::-1])
