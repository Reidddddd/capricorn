class NextGreaterElementI_496(object):
    def nextGreaterElement(self, findNums, nums):
        """
        :type findNums: List[int]
        :type nums: List[int]
        :rtype: List[int]
        """
        m = {}
        l = len(nums)
        for i in range(l):
            for j in range(i+1, l):
                if nums[j] > nums[i]:
                    map[nums[i]] = nums[j]
                    break
        for i in range(len(findNums)):
            findNums[i] = m.get(findNums[i], -1)
        return findNums
