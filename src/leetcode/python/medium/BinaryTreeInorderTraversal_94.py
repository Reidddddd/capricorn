class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BinaryTreeInorderTraversal_94(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []

        def add_val(node):
            if not node:
                return
            add_val(node.left)
            if node.val != '#':
                res.append(node.val)
            add_val(node.right)

        add_val(root)
        return res
