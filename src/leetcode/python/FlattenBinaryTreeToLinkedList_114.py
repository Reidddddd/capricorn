class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class FlattenBinaryTreeToLinkedList_114(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        if not root.left and not root.right:
            return

        self.flatten(root.right)
        self.flatten(root.left)
        if root.left and root.right:
            pre = root.left
            cur = pre.right
            while cur:
                pre = cur
                cur = pre.right
            pre.right = root.right
            root.right = root.left
            root.left = None
        if root.left and not root.right:
            root.right = root.left
            root.left = None
