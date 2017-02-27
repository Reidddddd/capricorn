class ClimbingStairs_70(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 2:
            return 1
        steps = [1] * (n+1)
        steps[2] = 2
        for i in range(3, n+1):
            steps[i] = steps[i-1] + steps[i-2]
        return steps[n]

