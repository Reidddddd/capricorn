class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class HouseRobberIII_337(object):
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        def dfs(node):
            if node is None:
                return [0, 0]
            left, right = dfs(node.left), dfs(node.right)
            return [node.val + left[1] + right[1],
                    max(left[0] + right[0], left[0] + right[1], left[1] + right[0], left[1] + right[1])]

        return max(dfs(root))
