class ReverseString_344(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str

        If len <= 1, no need to reverse.
        else using a reverse slice
        """
        if len(s) < 2:
            return s
        return s[::-1]
