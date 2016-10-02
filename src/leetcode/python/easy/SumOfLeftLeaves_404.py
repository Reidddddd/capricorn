class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class SumOfLeftLeaves_404(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def dfs(node, left):
            if not node:
                return 0
            if not node.left and not node.right and left:
                return node.val
            return dfs(node.left, True) + dfs(node.right, False)

        if not root or not root.left and not root.right:
            return 0
        return dfs(root.left, True) + dfs(root.right, False)
