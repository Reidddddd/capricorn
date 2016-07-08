class ReverseBits_190(object):
    def reverseBits(self, n):
        return int(bin(n)[2:].zfill(32)[::-1], 2)


re = ReverseBits_190
re.reverseBits(re, 6)