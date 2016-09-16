class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BalancedBinaryTree_110(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def dfs(node):
            if not node:
                return 0
            left, right = dfs(node.left), dfs(node.right)
            if left == -1 or right == -1 or abs(left - right) > 1:
                return -1
            return max(left, right) + 1

        return dfs(root) != -1
