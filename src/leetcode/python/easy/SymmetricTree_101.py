class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class SymmetricTree_101(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def symmetric(left, right):
            if not left and not right:
                return True
            elif left and not right or not left and right:
                return False
            if left.val != right.val:
                return False
            if not symmetric(left.left, right.right):
                return False
            return symmetric(left.right, right.left)

        if not root:
            return True
        return symmetric(root.left, root.right)
