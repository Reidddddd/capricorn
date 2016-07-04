class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class MaximumDepthOfBinaryTree_104(object):
    def maxDepth(self, root):
        """
        1. if root == null, return 0;
        2. else call maxDepth recursive.
        """
        if (root == None): return 0
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))
