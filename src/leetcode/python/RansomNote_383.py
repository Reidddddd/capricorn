from collections import Counter


class RansomNote_383(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        maz = Counter(magazine)
        for c in ransomNote:
            if c not in maz or maz[c] <= 0:
                return False
            maz[c] -= 1
        return True
