class CreateMaximumNumber_321(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        def max_sublist(nums, l):
            drop = len(nums) - l
            max_sub = []
            for num in nums:
                while drop and max_sub and max_sub[-1] < num:
                    max_sub.pop()
                    drop -= 1
                max_sub.append(num)
            return max_sub[:l]

        def merge(a, b):
            return [max(a, b).pop(0) for _ in a + b]

        l_1, l_2 = len(nums1), len(nums2)
        return max(merge(max_sublist(nums1, i), max_sublist(nums2, k - i))
                   for i in range(k + 1)
                   if i <= l_1 and k - i <= l_2)
