class Subsets_78(object):
    def subsets(self, nums):
        """
        """
        subset = [[]]

        for num in nums:
            subset += [i + [num] for i in subset]

        return subset