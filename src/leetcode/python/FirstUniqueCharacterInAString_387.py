class FirstUniqueCharacterInAString_387(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        import collections
        cnt = collections.Counter(s)
        for i in range(len(s)):
            if cnt[s[i]] == 1: return i
        return -1
