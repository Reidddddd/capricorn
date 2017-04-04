class TwoSumII_167(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        lo, hi = 0, len(numbers) - 1
        while lo < hi:
            if target > numbers[lo] + numbers[hi]:
                lo += 1
            elif target < numbers[lo] + numbers[hi]:
                hi -= 1
            else:
                break
        return [lo + 1, hi + 1]
