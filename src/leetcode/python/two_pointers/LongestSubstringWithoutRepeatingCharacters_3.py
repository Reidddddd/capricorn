class LongestSubstringWithoutRepeatingCharacters_3(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        dic, result, start = {}, 0, 0
        for i, ch in enumerate(s):
            if ch in dic:
                result = max(result, i - start)
                start = max(start, dic[ch] + 1)
            dic[ch] = i
        return max(result, len(s) - start)
