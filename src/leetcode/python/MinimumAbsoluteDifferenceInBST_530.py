class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class MinimumAbsoluteDifferenceInBST_530(object):
    def getMinimumDifference(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def inorder(node):
            return inorder(node.left) + [node.val] + inorder(node.right) if node else []

        n = inorder(root)
        return min([n[i + 1] - n[i] for i in range(len(n) - 1)])
