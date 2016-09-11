class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BinarySearchTreeIterator_173(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.cache = []
        while root:
            self.cache.append(root)
            root = root.left

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.cache) != 0

    def next(self):
        """
        :rtype: int
        """
        node = self.cache.pop()
        res = node.val
        node = node.right
        while node:
            self.cache.append(node)
            node = node.left
        return res
