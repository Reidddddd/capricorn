class RemoveElement_27(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        head = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[head] = nums[i]
                head += 1
        return head
