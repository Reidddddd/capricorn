class HappyNumber_202(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        def calculate(num):
            return sum([int(i) ** 2 for i in str(num)])

        slow = fast = n
        while True:
            slow = calculate(slow)
            fast = calculate(calculate(fast))
            if fast == 1:
                return True
            if fast == slow:
                return False
