class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class DiameterOfBinaryTree_543(object):
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        mx = [0, 0]

        def diameter(node):
            if not node:
                return 0

            l, r = diameter(node.left), diameter(node.right)
            mx[1] = max(l, r) + 1
            mx[0] = max(mx[0], l + r)
            return mx[1]

        diameter(root)
        return mx[0]
