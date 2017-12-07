class MaxAreaOfIsland_695(object):
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        r, c = len(grid), len(grid[0])

        def dfs(i, j):
            if 0 <= i < r and 0 <= j < c and grid[i][j]:
                grid[i][j] = 0
                return 1 + dfs(i + 1, j) + dfs(i, j + 1) + dfs(i, j - 1) + dfs(i - 1, j)
            return 0

        area = [dfs(k, l) for k in range(0, r) for l in range(0, c) if grid[k][l]]
        return max(area) if area else 0

