class RomanToInteger_13(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        m = {'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1}
        res = 0
        for i in range(len(s) - 1):
            if m[s[i]] < m[s[i + 1]]:
                res -= m[s[i]]
            else:
                res += m[s[i]]
        return res + m[s[-1]]
