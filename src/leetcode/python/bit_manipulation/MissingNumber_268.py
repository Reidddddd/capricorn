class MissingNumber_268(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        xor = 0
        i = 0
        for num in nums:
            xor = xor ^ i ^ num
            i += 1
        return xor ^ i
