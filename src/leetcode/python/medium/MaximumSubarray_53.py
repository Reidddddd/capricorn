class MaximumSubarray_53(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sub_max = mx = nums[0]
        for i in range(1, len(nums)):
            mx = max(max(sub_max+nums[i], nums[i]), max)
        return mx
