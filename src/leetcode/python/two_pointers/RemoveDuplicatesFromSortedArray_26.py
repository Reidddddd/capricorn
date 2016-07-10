class RemoveDuplicatesFromSortedArray_26(object):
    def removeDuplicates(self, nums):
        i = 0
        for n in nums:
            if i < 1 or n > nums[i - 1]:
                nums[i] = n
                i += 1
        return i
