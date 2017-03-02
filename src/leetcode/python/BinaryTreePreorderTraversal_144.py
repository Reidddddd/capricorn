class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BinaryTreePreorderTraversal_144(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        def addNode(node):
            if node is None:
                return
            if node.val != '#':
                res.append(node.val)
            addNode(node.left)
            addNode(node.right)
        res = []
        addNode(root)
        return res
