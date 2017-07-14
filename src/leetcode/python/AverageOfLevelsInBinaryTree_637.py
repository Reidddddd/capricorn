class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class AverageOfLevelsInBinaryTree_637(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        res = []
        if not root:
            return res
        queue = [root]
        while queue:
            res.append((sum(float(node.val) for node in queue) / len(queue)))
            queue = [child for node in queue for child in (node.left, node.right) if child]
        return res
