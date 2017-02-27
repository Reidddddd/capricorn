class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BinaryTreeRightSideView_199(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        def dfs(node, depth):
            if node:
                if len(rsw) == depth:
                    rsw.append(node.val)
                dfs(node.right, depth + 1)
                dfs(node.left, depth + 1)

        rsw = []
        dfs(root, 0)
        return rsw
