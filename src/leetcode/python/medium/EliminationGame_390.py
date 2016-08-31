class EliminationGame_390(object):
    def lastRemaining(self, n):
        """
        :type n: int
        :rtype: int
        """
        left = True
        step, head = 1, 1
        remaining = n
        while remaining > 1:
            if left or remaining % 2 == 1:
                head += step
            left = False if left else True
            remaining /= 2
            step *= 2
        return head
