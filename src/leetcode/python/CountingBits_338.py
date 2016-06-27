class CountingBits_338(object):
    def countBits(self, num):
        """
        Take number X for example, 10011001.
        Divide it in 2 parts:
        <1>.the last digit (1 or 0, which is (i&1), == (i%2))
        <2>.the other digits(the number of 1 is f[i >> 1], == f[i/2])
        """
        rlist = [0] * (num + 1)
        for i in range(num + 1):
            rlist[i] = (i & 1) + rlist[i >> 1]
        return rlist

cb = CountingBits_338()
lst = cb.countBits(10)
print(lst)