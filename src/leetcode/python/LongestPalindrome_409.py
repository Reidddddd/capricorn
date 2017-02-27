class LongestPalindrome_409(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        chars = {}
        for c in s:
            if c not in chars:
                chars[c] = 1
            else:
                chars[c] += 1
        l, fg = 0, False
        for ch in chars:
            f = chars.get(ch)
            if f % 2 == 0:
                l += f
            else:
                l += (f - 1)
                fg = True
        return l if not fg else l + 1
