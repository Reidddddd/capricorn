class NumberOfSegmentsInAString_434(object):
    def countSegments(self, s):
        """
        :type s: str
        :rtype: int
        """
        import re

        s = re.sub(" +", " ", s.strip())
        return 0 if s == "" else len(s.split(" "))
