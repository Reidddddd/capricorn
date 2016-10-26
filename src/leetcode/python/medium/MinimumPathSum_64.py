class MinimumPathSum_64(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        row, col = len(grid), len(grid[0])
        for i in range(1, col):
            grid[0][i] = grid[0][i-1] + grid[0][i]
        for j in range(1, row):
            grid[j][0] = grid[j-1][0] + grid[j][0]
        for i in range(1, row):
            for j in range(1, col):
                grid[i][j] = min(grid[i-1][j], grid[i][j-1]) + grid[i][j]
        return grid[-1][-1]
