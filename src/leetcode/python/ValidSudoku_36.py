class ValidSudoku_36(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        for row in board:
            rs = set()
            for e in row:
                if e in rs:
                    return False
                if e != '.':
                    rs.add(e)
        for i in range(9):
            cs = set()
            for j in range(9):
                if board[j][i] in cs:
                    return False
                if board[j][i] != '.':
                    cs.add(board[j][i])

        def valid_nine(n, m):
            ns = set()
            for k in range(n, n + 3):
                for h in range(m, m + 3):
                    if board[k][h] in ns:
                        return False
                    if board[k][h] != '.':
                        ns.add(board[k][h])
            return True

        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                if not valid_nine(i, j):
                    return False
        return True
