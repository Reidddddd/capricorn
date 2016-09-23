from heapq import *


class FindMedianFromDataStream_295(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.left = []
        self.right = []

    def addNum(self, num):
        """
        Adds a num into the data structure.
        :type num: int
        :rtype: void
        """
        if len(self.left) == len(self.right):
            heappush(self.right, -heappushpop(self.left, -num))
        else:
            heappush(self.left, -heappushpop(self.right, num))

    def findMedian(self):
        """
        Returns the median of current data stream
        :rtype: float
        """
        if len(self.left) == len(self.right):
            return float(self.right[0] - self.left[0]) / 2
        return float(self.right[0])
