import collections


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BinaryTreeZigzagLevelOrderTraversal_103(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        q = collections.deque([root])
        res = []
        while q:
            r = []
            for _ in range(len(q)):
                v = q.popleft()
                if v:
                    r.append(v.val)
                    q.append(v.left)
                    q.append(v.right)
            r = r[::-1] if len(res) % 2 else r
            if r:
                res.append(r)
        return res
