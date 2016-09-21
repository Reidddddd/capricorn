class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class MinimumDepthOfBinaryTree_111(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        d = map(self.minDepth, (root.left, root.right))
        return 1 + (min(d) or max(d))
