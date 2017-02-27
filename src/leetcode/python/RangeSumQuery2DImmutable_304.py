class RangeSumQuery2DImmutable_304(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        if not matrix:
            return
        r = len(matrix)
        if r == 0:
            return
        c = len(matrix[0])
        if c == 0:
            return
        self.dp = [[0 for i in range(c+1)] for j in range(r+1)]
        for i in range(1, r+1):
            for j in range(1, c+1):
                self.dp[i][j] = self.dp[i-1][j] + self.dp[i][j-1] - self.dp[i-1][j-1] + matrix[i-1][j-1]

    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        dp = self.dp
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1]
