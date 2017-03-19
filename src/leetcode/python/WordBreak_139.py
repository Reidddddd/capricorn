class WordBreak_139(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        l = len(s)+1
        dp = [False] * l
        dp[0] = True
        for i in range(1, l):
            for j in range(0, i):
                dp[i] |= dp[j] and s[j:i] in wordDict
        return dp[len(s)]
