class ThreeSum_15(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        nums.sort()
        for i in range(len(nums) - 2):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            lo, hi = i + 1, len(nums) - 1
            while lo < hi:
                subsum = nums[lo] + nums[hi]
                if subsum > -nums[i]:
                    hi -= 1
                elif subsum < -nums[i]:
                    lo += 1
                else:
                    result.append([nums[i], nums[lo], nums[hi]])
                    lo += 1
                    while lo < hi and nums[lo] == nums[lo - 1]:
                        lo += 1
                    hi -= 1
                    while lo < hi and nums[hi] == nums[hi + 1]:
                        hi -= 1
        return result
