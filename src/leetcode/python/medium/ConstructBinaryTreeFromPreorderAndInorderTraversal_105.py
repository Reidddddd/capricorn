class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class ConstructBinaryTreeFromPreorderAndInorderTraversal_105(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not preorder or not inorder:
            return None

        root = TreeNode(preorder.pop(0))
        val_idx = inorder.index(root.val)

        root.left = self.buildTree(preorder, inorder[:val_idx])
        root.right = self.buildTree(preorder, inorder[val_idx+1:])
        return root
