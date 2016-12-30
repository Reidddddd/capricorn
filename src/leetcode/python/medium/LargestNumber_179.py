class LargestNumber_179(object):
    # @param {integer[]} nums
    # @return {string}
    def largestNumber(self, nums):
        r = ''.join(sorted(map(str, nums), lambda a,b: [1, -1][a+b>b+a]))
        return r.lstrip('0') or '0'


l = LargestNumber_179()
a = [1, 2, 3, 4]
print(l.largestNumber(a))
print(str(a))
print(''.join(str(i) for i in a))