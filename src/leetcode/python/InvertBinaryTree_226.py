class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class InvertBinaryTree_226(object):
    def invertTree(self, root):
        """
        always remember check the initial state like empty, none
        swap is from top to down, then left to right
        """
        if (root == None): return root

        swap = root.left
        root.left = root.right
        root.right = swap
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root
