class ShortestUnsortedContinuousSubarray_581(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        end, start = -2, -1
        ma, mi = nums[0], nums[-1]
        n = len(nums)
        for i in range(1, n):
            ma = max(nums[i], ma)
            mi = min(nums[n - i - 1], mi)
            if nums[i] < ma:
                end = i
            if nums[n - i - 1] > mi:
                start = n - i - 1
        return end - start + 1
