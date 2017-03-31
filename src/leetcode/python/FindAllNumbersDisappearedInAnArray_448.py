class FindAllNumbersDisappearedInAnArray_448(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(len(nums)):
            next = nums[i] - 1
            while next >= 0 and nums[next] != -1:
                temp = next
                next = nums[next] - 1
                nums[next] = -1
        res = []
        for i, num in enumerate(nums):
            if num > 0:
                res.append(i + 1)
        return res
