class LongestIncreasingPathInAMatrix_329(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        def dfs(i, j):
            if not visited[i][j]:
                val = matrix[i][j]
                visited[i][j] = 1 + max(
                    dfs(i-1, j) if i and val < matrix[i-1][j] else 0,
                    dfs(i+1, j) if i < n-1 and val < matrix[i+1][j] else 0,
                    dfs(i, j-1) if j and val < matrix[i][j-1] else 0,
                    dfs(i, j+1) if j < m-1 and val < matrix[i][j+1] else 0
                )
            return visited[i][j]

        if not matrix:
            return 0
        n, m = len(matrix), len(matrix[0])
        visited = [[0] * m for i in range(n)]
        return max(dfs(i, j) for i in range(n) for j in range(m))
