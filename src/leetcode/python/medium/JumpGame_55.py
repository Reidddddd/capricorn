class JumpGame_55(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        length = len(nums)
        if length == 1:
            return True

        max_pos = -1
        for i, n in enumerate(nums):
            max_pos = max(i + n, max_pos)
            if n == 0 and i >= max_pos:
                break
            if max_pos >= length - 1:
                return True
        return False
