class ArithmeticSlices_413(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        i, res = 0, 0
        while i < len(A) - 2:
            if A[i+1] - A[i] == A[i+2] - A[i+1]:
                diff = A[i+1] - A[i]
                delta = 1
                res += delta
                j = i + 3
                while j < len(A) and A[j] - A[j-1] == diff:
                    delta += 1
                    res += delta
                    j += 1
                i = j - 1
                continue
            i += 1
        return res
