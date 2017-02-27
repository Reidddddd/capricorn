import collections
import random


class InsertDeleteGetRandomO1DuplicatesAllowed_381(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.index = []
        self.value = collections.defaultdict(set)

    def insert(self, val):
        """
        Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        self.index.append(val)
        self.value[val].add(len(self.index) - 1)
        return len(self.value[val]) == 1

    def remove(self, val):
        """
        Removes a value from the collection. Returns true if the collection contained the specified element.
        :type val: int
        :rtype: bool
        """
        if self.value[val]:
            idx = self.value[val].pop()
            val = self.index[-1]
            self.index[idx] = val
            if self.value[val]:
                self.value[val].add(idx)
                self.value[val].discard(len(self.index)-1)
            self.index.pop()
            return True
        return False

    def getRandom(self):
        """
        Get a random element from the collection.
        :rtype: int
        """
        return random.choice(self.index)
