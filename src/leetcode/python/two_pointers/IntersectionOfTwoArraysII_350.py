class IntersectionOfTwoArraysII_350(object):
    def intersect(self, nums1, nums2):
        from collections import Counter
        c1, c2 = Counter(nums1), Counter(nums2)
        return sum([[num] * min(c1[num], c2[num]) for num in c1 & c2], [])
