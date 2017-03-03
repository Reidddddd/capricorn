class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class KthSmallestElementInABST_230(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        def gen(node):
            if node is not None:
                for val in gen(node.left):
                    yield val
                yield node.val
                for val in gen(node.right):
                    yield val
        for val in gen(root):
            if k == 1:
                return val
            else:
                k -= 1
