class ThirdMaximumNumber_414(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = set(nums)
        if len(res) < 3:
            return max(res)
        res.remove(max(nums))
        res.remove(max(nums))
        return max(res)
