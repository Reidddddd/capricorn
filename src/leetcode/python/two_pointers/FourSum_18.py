class FourSum_18(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        nums.sort()
        for i in range(len(nums) - 3):
            if nums[i] << 2 > target:
                break
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(len(nums) - 1, i + 2, -1):
                if nums[j] << 2 < target:
                    break
                if j < len(nums) - 1 and nums[j] == nums[j + 1]:
                    continue
                lo, hi = i + 1, j - 1
                re = target - nums[i] - nums[j]
                while lo < hi:
                    subsum = nums[lo] + nums[hi]
                    if subsum > re:
                        hi -= 1
                    elif subsum < re:
                        lo += 1
                    else:
                        result.append([nums[i], nums[lo], nums[hi], nums[j]])
                        lo += 1
                        while lo < hi and nums[lo] == nums[lo - 1]:
                            lo += 1
                        hi -= 1
                        while lo < hi and nums[hi] == nums[hi + 1]:
                            hi -= 1

        return result
