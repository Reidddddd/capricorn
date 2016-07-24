class ThreeSumClosest_16(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        closest = sum(nums[0:3])
        if len(nums) == 3:
            return closest
        nums.sort()
        for i in range(len(nums) - 2):
            start, end = i + 1, len(nums) - 1
            while start < end:
                tsum = nums[i] + nums[start] + nums[end]
                if tsum == target:
                    return tsum
                elif tsum < target:
                    start += 1
                elif tsum > target:
                    end -= 1
                if abs(tsum - target) < abs(closest - target):
                    closest = tsum
        return closest
