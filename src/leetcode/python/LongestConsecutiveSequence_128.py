class LongestConsecutiveSequence_128(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        num = set(nums)
        res = 0
        for n in num:
            if n - 1 not in num:
                m = n + 1
                while m in num:
                    m += 1
                res = max(res, m - n)
        return res
