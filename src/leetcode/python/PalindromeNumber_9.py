class PalindromeNumber_9(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        y, rev = x, 0
        while y != 0:
            rev = rev * 10 + y % 10
            y /= 10
        return rev == x
