class SortColors_75(object):
    def sortColors(self, nums):
        zeroPos = 0
        twoPos = len(nums) - 1
        for i in range(twoPos + 1):
            while nums[i] == 2 and i < twoPos:
                nums[i], nums[zeroPos] = nums[zeroPos], nums[i]
                zeroPos += 1
            while nums[i] == 0 and i > zeroPos:
                nums[i], nums[twoPos] = nums[twoPos], nums[i]
                twoPos -= 1
