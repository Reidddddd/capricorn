class IsomorphicStrings_205(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        m = dict()
        rm = dict()
        for i in range(len(s)):
            l, r = s[i], t[i]
            if l not in m:
                if r in rm:
                    return False
                m[l] = r
                rm[r] = l
            else:
                if m[l] != r:
                    return False
        return True
