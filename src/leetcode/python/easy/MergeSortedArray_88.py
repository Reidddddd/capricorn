class MergeSortedArray_88(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.

        Idea: sorted reversely
        """
        while n > 0:
            k = m + n - 1
            if m == 0 or nums1[m - 1] < nums2[n - 1]:
                n -= 1
                nums1[k] = nums2[n]
            else:
                m -= 1
                nums1[k] = nums1[m]
