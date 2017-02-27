class SingleNumber_136(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int

        n ^ n = 0
        the last value will be the only one
        """
        return 2 * sum(set(nums)) - sum(nums)
