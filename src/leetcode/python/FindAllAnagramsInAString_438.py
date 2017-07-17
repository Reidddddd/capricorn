class FindAllAnagramsInAString_438(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        res = []
        if not s or not p:
            return res
        hs = [0] * 256
        for cs in p:
            hs[ord(cs)] += 1
        l, r, c = 0, 0, len(p)
        while r < len(s):
            if hs[ord(s[r])] > 0:
                c -= 1
            hs[ord(s[r])] -= 1
            r += 1
            if c == 0:
                res.append(l)
            if r - l == len(p):
                if hs[ord(s[l])] >= 0:
                    c += 1
                hs[ord(s[l])] += 1
                l += 1
        return res
