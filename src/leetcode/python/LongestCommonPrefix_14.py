class LongestCommonPrefix_14(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        k = len(strs)
        if k < 1:
            return ""
        first = strs[0]
        for i, ch in enumerate(first):
            for str in strs:
                if i >= len(str) or str[i] != ch:
                    return first[:i]
        return first
