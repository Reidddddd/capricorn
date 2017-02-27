class TreeLinkNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


class PopulatingNextRightPointersInEachNode_116(object):
    def connect(self, root):
        """
         :type root: TreeLinkNode
         :rtype: nothing
         """
        def node_connect(left, right):
            if not left: return
            left.next = right
            right.next = None
            node_connect(left.left, left.right)
            node_connect(left.right, right.left)
            node_connect(right.left, right.right)

        if not root: return
        root.next = None
        node_connect(root.left, root.right)
