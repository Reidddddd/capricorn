from collections import deque


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BinaryTreeLevelOrderTraversal_102(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []
        if not root:
            return res
        q = deque([root])
        size = len(q)
        while size != 0:
            l = []
            for i in range(size):
                node = q.popleft()
                l.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(l)
            size = len(q)
        return res
