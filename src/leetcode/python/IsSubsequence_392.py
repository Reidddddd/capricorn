class IsSubsequence_392(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if not s: return True
        if not t: return False
        index = -1
        for c in s:
            try:
                index = t.index(c, index + 1)
            except:
                return False
        return True
