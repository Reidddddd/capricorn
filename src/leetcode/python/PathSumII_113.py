class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class PathSumII_113(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if not root:
            return []
        if not root.left and not root.right:
            if root.val == sum:
                return [[root.val]]
            else:
                return []

        tmp = self.pathSum(root.left, sum-root.val) + \
            self.pathSum(root.right, sum-root.val)
        return [[root.val] + i for i in tmp]
