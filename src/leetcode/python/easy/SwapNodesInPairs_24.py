class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class SwapNodesInPairs_24(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return None
        if not head.next:
            return head
        head.next.next = self.swapPairs(head.next.next)
        h = head.next
        head.next = h.next
        h.next = head
        return h
