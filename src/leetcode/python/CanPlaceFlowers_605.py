class CanPlaceFlowers_605(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        planted = False
        for f in flowerbed:
            if f == 0:
                if not planted:
                    n -= 1
                planted = not planted
            else:
                if planted:
                    n += 1
                planted = True
        return n <= 0
