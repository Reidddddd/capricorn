class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class RemoveDuplicatesFromSortedList_83(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        cur = head
        while cur:
            while cur.next and cur.next.val == cur.val:
                cur.next = cur.next.next
            cur = cur.next
        return head

# old version:
#
# if head is None:
#     return None
# if head.next is None:
#     return head
# pre = nxt = head
# s = set()
# while nxt:
#     if nxt.val not in s:
#         s.add(nxt.val)
#         pre = nxt
#     else:
#         pre.next = nxt.next
#     nxt = nxt.next
# return head
