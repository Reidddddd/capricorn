class BaseballGame_682(object):
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        """
        stk = []
        for op in ops:
            if op == "+":
                stk.append(stk[-1] + stk[-2])
            elif op == "D":
                stk.append(stk[-1] * 2)
            elif op == "C":
                stk.pop()
            else:
                stk.append(int(op))
        return sum(stk)
