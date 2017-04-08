class RelativeRanks_506(object):
    def findRelativeRanks(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        m = {}
        for i, n in enumerate(nums):
            m[n] = i
        sorted_keys = [m[k] for k in sorted(m.keys(), reverse=True)]
        strs = [] * len(nums)
        rank = 1
        for i in sorted_keys:
            if rank == 1:
                strs[i] = "Gold Medal"
            elif rank == 2:
                strs[i] = "Silver Medal"
            elif rank == 3:
                strs[i] = "Bronze Medal"
            else:
                strs[i] = str(rank)
            rank += 1
        return strs
