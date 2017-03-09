class CountPrimes_204(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        not_prime = [False] * n
        count = 0
        for i in range(2, n):
            if not_prime[i] is False:
                count += 1
                j = 2
                while i * j < n:
                    not_prime[i * j] = True
                    j += 1
        return count
