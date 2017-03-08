class MaximumProductSubarray_152(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        r = nums[0]
        tmax = tmin = r
        for i in range(1, len(nums)):
            if nums[i] < 0:
                tmax, tmin = tmin, tmax
            tmax = max(nums[i], nums[i]*tmax)
            tmin = min(nums[i], nums[i]*tmin)
            r = max(tmax, r)
        return r
