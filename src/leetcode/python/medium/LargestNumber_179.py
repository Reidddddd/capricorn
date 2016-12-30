class LargestNumber_179(object):
    # @param {integer[]} nums
    # @return {string}
    def largestNumber(self, nums):
        r = ''.join(sorted(map(str, nums), lambda a,b: [1, -1][a+b>b+a]))
        return r.lstrip('0') or '0'
