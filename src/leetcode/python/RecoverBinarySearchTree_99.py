class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class RecoverBinarySearchTree_99(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        def travel(n):
            if n:
                for nd in travel(n.left):
                    yield nd
                yield n
                for nd in travel(n.right):
                    yield nd

        first, second, temp = None, None, None
        for node in travel(root):
            if temp:
                if not first and temp.val >= node.val:
                    first = temp
                if first and temp.val >= node.val:
                    second = node
            temp = node
        first.val, second.val = second.val, first.val
