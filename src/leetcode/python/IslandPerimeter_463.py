class IslandPerimeter_463(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        row, col = len(grid), len(grid[0])
        per = [0] * 5

        def check(k, l):
            permeter = 0
            if i - 1 < 0 or grid[i - 1][j] == 0: permeter += 1
            if i + 1 >= row or grid[i + 1][j] == 0: permeter += 1
            if j - 1 < 0 or grid[i][j - 1] == 0: permeter += 1
            if j + 1 >= col or grid[i][j + 1] == 0: permeter += 1
            return permeter

        for i in range(row):
            for j in range(col):
                if grid[i][j] == 1:
                    per[check(i, j)] += 1

        res = 0
        for i, n in enumerate(per):
            res = i * n
        return res
