class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class PathSum_112(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        def path_sum(node, tmp, sum):
            if not node: return False
            tmp += node.val
            if not node.left and not node.right:
                return True if tmp == sum else False
            if path_sum(node.left, tmp, sum): return True
            return path_sum(node.right, tmp, sum)

        tmp = 0
        return path_sum(root, 0, sum)
