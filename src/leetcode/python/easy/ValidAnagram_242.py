from collections import Counter


class ValidAnagram_242(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        sc, tc = Counter(s), Counter(t)
        return sc == tc
