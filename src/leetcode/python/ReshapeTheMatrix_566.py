class ReshapeTheMatrix_566(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        if r * c != len(nums) * len(nums[0]):
            return nums
        t = []
        for x in nums:
            t.extend(x)
        return [t[i * c: i * c + c] for i in range(r)]
