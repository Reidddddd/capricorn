class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class ValidateBinarySearchTree_98(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def validSubTree(node, lf, rg):
            if not node:
                return True
            if lf is not None and lf >= node.val:
                return False
            if rg is not None and node.val >= rg:
                return False
            if not node.left and not node.right:
                return True
            return validSubTree(node.left, lf, node.val) and validSubTree(node.right, node.val, rg)

        if not root or not root.left and not root.right:
            return True
        l, v, r = None, root.val, None
        return validSubTree(root.left, l, root.val) and validSubTree(root.right, root.val, r)
