class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BinaryTreePostorderTraversal_145(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        traversal, stack = [], [root]
        while stack:
            node = stack.pop()
            if node:
                traversal.append(node.val)
                stack.append(node.left)
                stack.append(node.right)
        return traversal[::-1]
