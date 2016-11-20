class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class DeleteNodeInALinkedList_237(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        if not node or not node.next:
            return
        node.val = node.next.val
        node.next = node.next.next
