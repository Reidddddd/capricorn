class MinimumSizeSubarraySum_209(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        import sys
        i, j, subsum = 0, 0, 0
        minlen = sys.maxsize
        while j < len(nums):
            subsum += nums[j]
            j += 1
            while subsum >= s:
                minlen = min(minlen, j - i)
                subsum -= nums[i]
                i += 1
        return minlen if minlen != sys.maxsize else 0
