class AssignCookies_455(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g, s = sorted(g), sorted(s)
        i, j = 0, 0
        res = 0
        for i in range(len(s)):
            if s[i] > g[j]:
                res += 1
                j += 1
            if j == len(s):
                break
        return res
