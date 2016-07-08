class SingleNumberII_137(object):
    def singleNumber(self, nums):
        one = 0x0
        two = 0x0
        for num in nums:
            one = one ^ num & ~two
            two = two ^ num & ~one
        return one