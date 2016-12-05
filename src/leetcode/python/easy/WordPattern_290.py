class WordPattern_290(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        strs = str.split(" ")
        if len(strs) != len(pattern):
            return False
        i = 0
        m, rm = {}, {}
        for l, r in zip(pattern, strs):
            if l in m and m[l] != r or r in rm and rm[r] != l:
                return False
            m[l], rm[r] = r, l
        return True
