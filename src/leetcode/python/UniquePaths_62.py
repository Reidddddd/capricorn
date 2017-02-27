class UniquePaths_62(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        maze = [[1 for x in range(n)] for x in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                maze[i][j] = maze[i-1][j] + maze[i][j-1]
        return maze[-1][-1]
