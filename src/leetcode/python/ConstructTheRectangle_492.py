import math


class ConstructTheRectangle_492(object):
    def constructRectangle(self, area):
        """
        :type area: int
        :rtype: List[int]
        """
        limit = int(math.sqrt(area))
        while area % limit != 0:
            limit -= 1
        return [area / limit, limit]
