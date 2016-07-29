class MinimumWindowSubstring_76(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if len(s) < len(t):
            return ""
        import sys
        length = sys.maxsize
        required = [0] * 256
        found = [0] * 256
        cnt = 0
        for i in range(len(t)):
            required[ord(t[i])] += 1
        k = 0
        start = -1
        for j in range(len(s)):
            if required[ord(s[j])] == 0:
                continue
            found[ord(s[j])] += 1
            if found[ord(s[j])] <= required[ord(s[j])]:
                cnt += 1
            if cnt == len(t):
                while required[ord(s[k])] == 0 or found[ord(s[k])] > required[ord(s[k])]:
                    if found[ord(s[k])] > required[ord(s[k])]:
                        found[ord(s[k])] -= 1
                    k += 1
                if j - k + 1 < length:
                    length = j - k + 1
                    start = k
        return "" if length == sys.maxsize else s[start:start + length]
