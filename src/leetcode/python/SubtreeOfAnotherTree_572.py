class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class SubtreeOfAnotherTree_572(object):
    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        if s is None:
            return False

        def isEqual(l, r):
            if l is None and r is None:
                return True
            if l is None or r is None:
                return False
            if l.val != r.val:
                return False
            return isEqual(l.left, r.left) and isEqual(l.right, r.right)

        if isEqual(s, t):
            return True
        return self.isSubtree(s.left, t) or self.isSubtree(s.right, t)
