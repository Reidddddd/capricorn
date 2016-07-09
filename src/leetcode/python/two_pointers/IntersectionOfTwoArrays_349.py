class IntersectionOfTwoArrays_349(object):
    def intersection(self, nums1, nums2):
        """
        The code is straightforward
        """
        set1 = set(nums1)
        set2 = set(nums2)
        inter = set1 & set2
        return list(inter)
