class NumberOfIslands_200(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        def dfs(i, j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[i]) or grid[i][j] == '0':
                return 0
            grid[i][j] = '0'
            map(dfs, (i+1, i-1, i, i), (j, j, j-1, j+1))
            return 1
        return sum(dfs(i, j) for i in range(len(grid)) for j in range(len(grid[i])))
