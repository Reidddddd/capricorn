class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class RemoveNthNodeFromEndOfList_19(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        nth = fast = head
        for _ in range(n):
            fast = fast.next
        if not fast:
            return head.next
        while fast.next:
            fast = fast.next
            nth = nth.next
        nth.next = nth.next.next
        return head
