class HouseRobberII_213(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        def _rob(robs):
            dp_0, dp_1 = 0, 0
            for i in robs:
                dp_1, dp_0 = max(dp_0 + i, dp_1), dp_1
            return dp_1

        return max(_rob(nums[:-1]), _rob(nums[1:])) if len(nums) != 1 else nums[0]
