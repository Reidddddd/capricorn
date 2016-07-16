class SingleNumberIII_260(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]

        1. we XOR all elements in the array, and get the XOR of the two numbers we need
        to find. Note that since the two numbers are distinct, so there must be a set bit (that is, the
        bit with value '1') in the XOR result. Find out an arbitrary set bit (for example, the
        rightmost set bit).

        2. we divide all numbers into two groups, one with the aforementioned bit set,
        another with the aforementinoed bit unset. Two different numbers we need to find must fall into
        the two distinct groups. XOR numbers in each group, we can find a number in either group.
        """
        xor = 0
        for num in nums: xor ^= num
        xor &= -xor
        a = 0
        b = 0
        for num in nums:
            if (num & xor) == 0:
                a ^= num
            else:
                b ^= num
        return [a, b]
