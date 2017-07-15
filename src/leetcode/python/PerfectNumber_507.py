class PerfectNumber_507(object):
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 2:
            return False

        end = int(num ** 0.5)
        res = sum(i + num // i for i in range(2, end + 1) if not num % i)
        res += 1
        return res == num
