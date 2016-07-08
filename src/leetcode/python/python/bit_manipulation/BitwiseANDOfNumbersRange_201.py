class BitwiseANDOfNumbersRange_201(object):
    def rangeBitwiseAnd(self, m, n):
        if m == 0: return 0
        shift = 0
        while (m != n):
            m >>= 1
            n >>= 1
            shift += 1
        return n << shift