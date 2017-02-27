class HouseRobber_198(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        prev_0, prev_1 = 0, 0
        for i in nums:
            prev_0, prev_1 = prev_1, max(i + prev_0, prev_1)
        return max(prev_0, prev_1)
