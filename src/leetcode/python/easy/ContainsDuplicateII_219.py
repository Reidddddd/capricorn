from collections import deque


class ContainsDuplicateII_219(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        s = set()
        for i, v in enumerate(nums):
            if i > k:
                s.remove(nums[i - k - 1])
            if v in s:
                return True
            s.add(v)
        return False
