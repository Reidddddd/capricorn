class Iterator(object):
    def __init__(self, nums):
        """
        Initializes an iterator object to the beginning of a list.
        :type nums: List[int]
        """

    def hasNext(self):
        """
        Returns true if the iteration has more elements.
        :rtype: bool
        """

    def next(self):
        """
        Returns the next element in the iteration.
        :rtype: int
        """


class PeekingIterator_284(object):
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        self.iter = iterator
        self.hasElement = False
        self.integer = None

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        if not self.hasElement:
            self.integer = self.iter.next()
            self.hasElement = True
        return self.integer

    def next(self):
        """
        :rtype: int
        """
        if self.hasElement:
            self.hasElement = False
            return self.integer
        return self.iter.next()

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.hasElement or self.iter.hasNext()
