class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class ReverseLinkedList_206(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return None
        elif not head.next:
            return head

        # tail = head.next
        # head.next = None
        tail, head.next = head.next, None
        while tail:
            tmp = tail.next
            # tail.next = head
            # head = tail
            # tail = tmp
            tail.next, head, tail = head, tail, tmp
        return head
