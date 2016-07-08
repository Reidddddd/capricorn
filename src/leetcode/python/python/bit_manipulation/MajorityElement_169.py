class MajorityElement_169(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lens = len(nums)
        major = nums[0]
        count = 1
        for num in nums[1:]:
            if num != major:
                count -= 1
                if count == 0:
                    count = 1
                    major = num
            else:
                count += 1
                if count > lens / 2:
                    break
        return major