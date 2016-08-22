class RemoveDuplicateLetters_316(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return ""
        import collections
        cnt = collections.Counter(list(s))
        pos = 0
        for i, x in enumerate(s):
            if x < s[pos]:
                pos = i
            cnt[x] -= 1
            if cnt[x] == 0:
                break
        return s[pos] + self.removeDuplicateLetters(s[pos+1:].replace(s[pos], ""))
