class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class ConvertSortedArrayToBinarySearchTree_108(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        length = len(nums)
        if length == 0: return None
        mid = length / 2
        head = TreeNode(nums[mid])
        head.left = self.leaf_node(nums, 0, mid)
        head.right = self.leaf_node(nums, mid + 1, length)
        return head

    def leaf_node(self, nums, i, j):
        if i == j: return None
        mid = (i + j) / 2
        leaf = TreeNode(nums[mid])
        leaf.left = self.leaf_node(nums, i, mid)
        leaf.right = self.leaf_node(nums, mid + 1, j)
        return leaf
