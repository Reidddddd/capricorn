class LengthOfLastWord_58(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        return 0 if len(s.split()) == 0 else len(s.split()[-1])
