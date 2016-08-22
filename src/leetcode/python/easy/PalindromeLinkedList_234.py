class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class PalindromeLinkedList_234(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or not head.next:
            return True
        fast = head
        mid = head
        while fast and fast.next:
            fast, mid = fast.next.next, mid.next

        pt = self.reverseList(mid)
        while head and pt:
            if head.val != pt.val:
                return False
            head, pt = head.next, pt.next
        return True

    def reverseList(self, head):
        if not head:
            return None
        elif not head.next:
            return head
        tail, head.next = head.next, None
        while tail:
            tmp = tail.next
            tail.next, head, tail = head, tail, tmp
        return head
