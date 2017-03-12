class LongestPalindromicSubstring_5(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        t = [0] * 2
        l = len(s)
        if l < 2:
            return s

        def checkPadlindrom(j, k):
            while j>=0 and k<l and s[j]==s[k]:
                j -= 1
                k += 1
            if t[1] < k-j-1:
                t[0], t[1] = j+1, k-j-1

        for i in range(l):
            checkPadlindrom(i, i)
            checkPadlindrom(i, i+1)
        return s[t[0]:t[0]+t[1]]
