class MaximumAverageSubarrayI_643(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        window = 0
        for i in k:
            window += nums[i]
        res = window
        for i in range(k, len(nums)):
            window += (nums[i] - nums[i - k])
            res = max(res, window)
        return float(res) / k
