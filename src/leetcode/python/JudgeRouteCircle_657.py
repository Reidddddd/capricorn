class JudgeRouteCircle_657(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        circle = 0
        for m in moves:
            if m == 'U': circle += 1
            elif m == 'D': circle -= 1
            elif m == 'L': circle += 2
            elif m == 'R': circle -= 2
        return circle == 0
