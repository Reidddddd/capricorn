class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class ConvertBSTToGreaterTree_538(object):
    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return None
        res = []

        def bstTrav(node):
            if not node:
                return
            bstTrav(node.right)
            tmp = node.val
            node.val += res[0]
            res[0] += tmp
            bstTrav(node.left)
            return

        bstTrav(root)
        return root
