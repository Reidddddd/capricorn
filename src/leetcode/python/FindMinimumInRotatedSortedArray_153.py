class FindMinimumInRotatedSortedArray_153(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i, j = 0, len(nums)-1
        while i < j:
            m = (i + j) / 2
            if nums[m] > nums[j]:
                i = m + 1
            else:
                j = m
        return nums[i]
