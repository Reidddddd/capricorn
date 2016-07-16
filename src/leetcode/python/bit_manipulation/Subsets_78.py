class Subsets_78(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        subset = [[]]

        for num in nums:
            subset += [i + [num] for i in subset]
        return subset
