import collections


class TwoSum_1(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        index = {}
        for i in range(len(nums)):
            k = target - nums[i]
            if nums[i] in index:
                return [index[nums[i]], i]
            else:
                index[k] = i
