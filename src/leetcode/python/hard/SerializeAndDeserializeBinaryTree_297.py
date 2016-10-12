class Index(object):
    def __init__(self, x):
        self.index = x


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class SerializeAndDeserializeBinaryTree_297(object):
    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        def serial(node):
            if node is None:
                ser.append("$,")
                return
            ser.append(str(node.val) + ",")
            serial(node.left)
            serial(node.right)

        ser = []
        serial(root)
        return ''.join(ser)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        def deserial():
            if i.index >= len(sd) or i.index < len(sd) and sd[i.index] == "$":
                return None
            node = TreeNode(int(sd[i.index]))
            i.index += 1
            node.left = deserial()
            i.index += 1
            node.right = deserial()
            return node

        sd = data.split(",")
        i = Index(0)
        return deserial()
