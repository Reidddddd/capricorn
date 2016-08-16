class PatchingArray_330(object):
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        miss, patch, index = 1, 0, 0
        length = len(nums)
        while miss <= n:
            if index < length and nums[index] <= miss:
                miss += nums[index]
                index += 1
            else:
                miss += miss
                patch += 1
        return patch
