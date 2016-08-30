class FindTheDifference_389(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        import collections
        c = collections.Counter(s)
        for ch in t:
            c[ch] -= 1
            if c[ch] < 0:
                return ch
        return '\u0000'
