class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class AddTwoNumbers_2(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        plus = 0
        head = l2
        while l1 and l2:
            val = l1.val + l2.val + plus
            l2.val = val % 10
            plus = val / 10
            if l1.next is None or l2.next is None:
                break
            l1, l2 = l1.next, l2.next
        while l1.next:
            l1 = l1.next
            val = l1.val + plus
            l2.next = ListNode(val % 10)
            plus = val / 10
            l2 = l2.next
        while l2.next:
            l2 = l2.next
            val = l2.val + plus
            l2.val = val % 10
            plus = val / 10
        if plus:
            l2.next = ListNode(1)
        return head
