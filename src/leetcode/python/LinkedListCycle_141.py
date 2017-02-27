class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class LinkedListCycle_141(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None:
            return False
        slow = head
        while head is not None and head.next is not None:
            head = head.next.next
            slow = slow.next
            if head == slow:
                return True
        return False
