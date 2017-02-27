class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class PartitionList_86(object):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        if not head:
            return None
        shd = smaller = ListNode(-1)
        bhd = bigger = ListNode(-1)
        while head:
            if head.val >= x:
                bigger.next = head
                bigger = bigger.next
            else:
                smaller.next = head
                smaller = smaller.next
            head = head.next
        smaller.next = bhd.next
        bigger.next = None
        return shd.next
