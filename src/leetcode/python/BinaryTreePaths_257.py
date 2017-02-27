class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BinaryTreePaths_257(object):
    # @param {TreeNode} root
    # @return {string[]}
    def binaryTreePaths(self, root):
        res, stack = [], []
        if not root:
            return res
        stack.append([root, str(root.val)])
        while stack:
            node, val = stack.pop()
            if not node.left and not node.right:
                res.append(val)
            if node.right:
                stack.append([node.right, val+'->'+str(node.right.val)])
            if node.left:
                stack.append([node.left, val+'->'+str(node.left.val)])
        return res
