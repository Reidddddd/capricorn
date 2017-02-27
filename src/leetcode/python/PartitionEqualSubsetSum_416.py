class PartitionEqualSubsetSum_416(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        sm = sum(nums)
        if sm % 2 != 0:
            return False
        sm /= 2
        reachable = [False] * (sm + 1)
        reachable[0] = True
        for n in nums:
            for j in range(sm, n, -1):
                reachable[j] = reachable[j] or reachable[j - n]
        return reachable[sm]
