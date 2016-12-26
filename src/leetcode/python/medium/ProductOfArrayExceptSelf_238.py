class ProductOfArrayExceptSelf_238(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        l = len(nums)
        left_product = [1] * l
        for i in range(1, l):
            left_product[i] = left_product[i-1] * nums[i-1]
        right_product = 1
        for i in range(l-1, -1, -1):
            left_product[i] = left_product[i] * right_product
            right_product *= nums[i]
        return left_product
