class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class RotateList_61(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if not head:
            return None
        elif k == 0:
            return head
        size = slow = fast = head
        len = 0
        while size:
            size = size.next
            len += 1
        k %= len
        while k > 0:
            k -= 1
            fast = fast.next
        if fast == slow:
            return head
        while fast.next:
            fast, slow = fast.next, slow.next
        fast.next = head
        head = slow.next
        slow.next = None
        return head
