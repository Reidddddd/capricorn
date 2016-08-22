class WiggleSubsequence_376(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length == 0:
            return 0

        up, down = False, False
        previou = nums[0]
        max_len = 1
        i = 1
        while i < length:
            if nums[i] - previou > 0 and not up:
                while i < length and nums[i] > nums[i - 1]:
                    i += 1
                i -= 1
                previou = nums[i]
                up = True
                max_len += 1
                if up and down:
                    down = False
            elif nums[i] - previou < 0 and not down:
                while i < length and nums[i] < nums[i - 1]:
                    i += 1
                i -= 1
                previou = nums[i]
                down = True
                max_len += 1
                if up and down:
                    up = False
            i += 1
        return max_len
