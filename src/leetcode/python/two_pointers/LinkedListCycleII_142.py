class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class LinkedListCycleII_142(object):
    def detectCycle(self, head):
        if head is None:
            return None
        slow = head
        fast = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if slow == fast:
                break
        else:
            return None
        while head != slow:
            head = head.next
            slow = slow.next
        return head
