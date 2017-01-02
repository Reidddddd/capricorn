class SpiralMatrix_54(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if not matrix or not matrix[0]:
            return []
        row, col = len(matrix), len(matrix[0])
        left, right = 0, col-1
        top, down = 0, row-1
        ans = []
        while left < right and top < down:
            ans.extend([matrix[top][i] for i in range(left, right)])
            ans.extend([matrix[i][right] for i in range(top, down)])
            ans.extend(matrix[down][i] for i in range(right, left, -1))
            ans.extend(matrix[i][left] for i in range(down, top, -1))
            left, right = left+1, right-1
            top, down = top+1, down-1
        if left == right:
            ans.extend([matrix[i][right] for i in range(top, down+1)])
        elif top == down:
            ans.extend([matrix[down][i] for i in range(left, right+1)])
        return ans
