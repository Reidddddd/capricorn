class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class ConstructBinaryTreeFromInorderAndPostorderTraversal_106(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if not inorder or not postorder:
            return None

        root = TreeNode(postorder.pop())
        val_idx = inorder.index(root.val)

        root.right = self.buildTree(inorder[val_idx+1:], postorder)
        root.left = self.buildTree(inorder[:val_idx], postorder)
        return root

