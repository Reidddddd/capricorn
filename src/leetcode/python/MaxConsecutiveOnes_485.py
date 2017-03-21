class MaxConsecutiveOnes_485(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mx, cnt = 0, 0
        for i in nums:
            if i == 1:
                cnt += 1
            else:
                mx = max(mx, cnt)
                cnt =0
        return max(mx, cnt)
