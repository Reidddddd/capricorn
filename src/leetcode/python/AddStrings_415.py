class AddStrings_415(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if len(num2) > len(num1):
            num1, num2 = num2, num1
        res = []

        def addStr(l, r, c):
            t = int(l) + int(r)
            if c:
                t += 1
            res.append(str(t % 10))
            return t >= 10

        nl, nr = len(num1) - 1, len(num2) - 1
        b = False
        while nr >= 0:
            b = addStr(num1[nl], num2[nr], b)
            nl, nr = nl - 1, nr - 1
        while nl >= 0:
            b = addStr(num1[nl], '0', b)
            nl -= 1
        if b:
            res.append("1")
        return ''.join(res[::-1])
