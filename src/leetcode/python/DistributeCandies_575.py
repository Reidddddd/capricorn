class DistributeCandies_575(object):
    def distributeCandies(self, candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        l = len(candies) / 2
        sister = set()
        for c in candies:
            if c not in sister:
                sister.add(c)
                if len(sister) == l:
                    return l
        return len(sister)
