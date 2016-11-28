class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class LowestCommonAncestorOfABinarySearchTree_235(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return None
        if p and not q:
            return p
        if not p and q:
            return q
        if p.val < root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val > root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        return root
