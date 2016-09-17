class InsertDeleteGetRandomO1_380(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.index, self.dic = [], {}

    def insert(self, val):
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        if val not in self.dic:
            self.index.append(val)
            self.dic[val] = len(self.index) - 1
            return True
        return False

    def remove(self, val):
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        :type val: int
        :rtype: bool
        """
        if val in self.dic:
            idx, last = self.dic[val], self.index[-1]
            self.index[idx], self.dic[last] = last, idx
            self.index.pop()
            self.dic.pop(val)
            return True
        return False

    def getRandom(self):
        """
        Get a random element from the set.
        :rtype: int
        """
        import random
        return self.index[random.randint(0, len(self.index) - 1)]
