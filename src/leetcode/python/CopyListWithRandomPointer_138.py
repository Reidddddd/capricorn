class RandomListNode(object):
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None


class CopyListWithRandomPointer_138(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if not head:
            return None
        node = head
        table = {}
        while node:
            table[node] = RandomListNode(node.label)
            node = node.next
        node = head
        while node:
            if node.next:
                table[node].next = table[node.next]
            if node.random:
                table[node].random = table[node.random]
            node = node.next
        return table[head]
