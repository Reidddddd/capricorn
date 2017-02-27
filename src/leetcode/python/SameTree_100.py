class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class SameTree_100(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        if not p and not q: return True
        if p and not q or not p and q: return False
        if p.val != q.val: return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
