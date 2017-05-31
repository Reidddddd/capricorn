class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class RemoveLinkedListElements_203(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        if not head:
            return head
        p = ListNode(-1)
        p.next = head
        it = p
        while it and it.next:
            if it.next.val == val:
                it.next = it.next.next
            else:
                it = it.next
        return p.next
