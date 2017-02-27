class TreeLinkNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


class PopulatingNextRightPointersInEachNodeII_117(object):
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        def next_node(linke_node):
            node = linke_node.next
            while node:
                if node.left: return node.left
                if node.right: return node.right
                node = node.next
            return None

        if not root:
            return

        parent, left_most = None, root
        while left_most:
            parent = left_most
            left_most = None
            while parent:
                if parent.left:
                    parent.left.next = parent.right if parent.right else next_node(parent)
                    if not left_most:
                        left_most = parent.left
                if parent.right:
                    parent.right.next = next_node(parent)
                    if not left_most:
                        left_most = parent.right
                parent = parent.next
