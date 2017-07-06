class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BinaryTreeTilt_563(object):
    def findTilt(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = [0]

        def sufTrav(node):
            if not node:
                return 0
            l = sufTrav(node.left)
            r = sufTrav(node.right)
            res[0] += abs(l - r)
            return node.val + l + r

        if not root:
            return 0
        return abs(sufTrav(root.left) - sufTrav(root.right)) + res[0]
