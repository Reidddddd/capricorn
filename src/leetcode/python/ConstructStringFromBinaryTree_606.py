class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class ConstructStringFromBinaryTree_606(object):
    def tree2str(self, t):
        """
        :type t: TreeNode
        :rtype: str
        """
        if t is None:
            return ""
        res = []

        def preTrav(node):
            res.append('(')
            appendNode(node)
            res.append(')')

        def appendNode(treenode):
            res.append(str(treenode.val))
            if treenode.left:
                preTrav(treenode.left)
            if treenode.right:
                if treenode.left is None:
                    res.append("()")
                preTrav(treenode.right)

        appendNode(t)
        return "".join(str(res))
