class NimGame_292(object):
    def canWinNim(self, n):
        """
        :type n: int
        :rtype: bool

        if n % 4 != 0, the first just take numbers that equals multiple of 4
        else lose, for the latter pick can do the same thing to win
        """
        return True if n % 4 != 0 else False
