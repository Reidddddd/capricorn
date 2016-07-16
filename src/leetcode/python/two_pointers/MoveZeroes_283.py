class MoveZeroes_283(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        index = 0
        for num in nums:
            if num:
                nums[index] = num
                index += 1
        while index < len(nums):
            nums[index] = 0
            index += 1