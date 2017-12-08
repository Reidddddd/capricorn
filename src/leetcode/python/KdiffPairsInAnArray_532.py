import collections

class KdiffPairsInAnArray_532(object):
    def findPairs(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if k < 0:
            return 0

        cnt = collections.Counter(nums)
        pairs = 0
        for c in cnt:
            if k == 0 and cnt[c] > 1:
                pairs += 1
            elif k != 0 and cnt[c + k]:
                pairs += 1
        return pairs
