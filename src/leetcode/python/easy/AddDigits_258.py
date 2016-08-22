class AddDigits_258(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int

        Digital root
        Congruence formula
        """
        if num is 0:
            return 0
        temp = num % 9
        return 9 if temp is 0 else temp
