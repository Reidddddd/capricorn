class GasStation_134(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        length = len(gas)
        complete = sum(gas[i] - cost[i] for i in range(length))
        if complete < 0: return -1

        start, sub = 0, 0
        for i in range(length):
            sub += gas[i] - cost[i]
            if sub < 0:
                sub = 0
                start = i + 1
        return start
