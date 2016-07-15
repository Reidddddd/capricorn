class ImplementStrStr_28(object):
    """
    The fastest way:　↓
    for i in range(len(haystack) - len(needle) + 1):
        if haystack[i:i + len(needle)] == needle:
            return i
    return -1
    """
    def strStr(self, haystack, needle):
        if len(haystack) < len(needle):
            return -1
        elif not len(haystack) or not len(needle):
            return 0

        for i in range(len(haystack) - len(needle) + 1):
            j = 0
            if haystack[i] == needle[j]:
                k = i
                while j < len(needle) and haystack[k] == needle[j]:
                    k += 1
                    j += 1
                if j == len(needle):
                    return i
        return -1
