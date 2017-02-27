class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class ConvertSortedListToBinarySearchTree_109(object):
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        if not head:
            return None
        if not head.next:
            return TreeNode(head.val)
        mid = fast = head
        before_mid = None
        while head and head.next:
            head = head.next.next
            before_mid = mid
            mid = mid.next
        if before_mid:
            before_mid.next = None
        node = TreeNode(mid.val)
        node.left = TreeNode(head)
        node.right = TreeNode(mid)
        return node
