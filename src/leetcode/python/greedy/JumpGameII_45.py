class JumpGameII_45(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length == 1:
            return 0

        index = 0
        count = 0
        while True:
            if nums[index] + index >= length - 1:
                count += 1
                break
            pre_index = index
            i = pre_index + nums[pre_index]
            maxtmp = -1
            while i >= pre_index:
                if i + nums[i] > maxtmp:
                    maxtmp = i + nums[i]
                    index = i
                i -= 1
            count += 1
        return count
