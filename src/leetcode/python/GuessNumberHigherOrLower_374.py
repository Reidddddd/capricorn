class GuessNumberHigherOrLower_374(object):
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        h, t = 1, n
        while h < t:
            m = h + (t - h) / 2
            if guess(m) > 0:
                h = m + 1
            elif guess(m) < 0:
                t = m
            else:
                h = m
                break
        return h
