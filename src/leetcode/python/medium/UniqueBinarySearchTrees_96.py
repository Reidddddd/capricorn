class UniqueBinarySearchTrees_96(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        path = [0] * (n + 1)
        path[0] = path[1] = 1
        i = 2
        while i <= n:
            j = i
            while j >= 1:
                path[i] += path[j - 1] * path[i - j]
                j -= 1
            i += 1
        return path[n]
