class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BinaryTreeMaximumPathSum_124(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def calculate(node):
            if not node:
                return 0
            lmax = max(0, calculate(node.left))
            rmax = max(0, calculate(node.right))
            path_max[0] = max(path_max[0], lmax + rmax + node.val)
            return max(lmax, rmax) + node.val

        path_max = [0]
        if root:
            path_max[0] = root.val
        else:
            return 0
        calculate(root)
        return path_max[0]
