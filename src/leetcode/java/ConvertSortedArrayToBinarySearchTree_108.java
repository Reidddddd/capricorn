package leetcode.java;

public class ConvertSortedArrayToBinarySearchTree_108 {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) return null;
    TreeNode head = new TreeNode(nums[nums.length / 2]);
    head.left = getLeafNode(nums, 0, nums.length / 2);
    head.right = getLeafNode(nums, nums.length / 2 + 1, nums.length);
    return head;
  }

  private TreeNode getLeafNode(int[] nums, int i, int j) {
    if (i == j) return null;
    int mid = (i + j) / 2;
    TreeNode leaf = new TreeNode(nums[mid]);
    leaf.left = getLeafNode(nums, i, mid);
    leaf.right = getLeafNode(nums, mid + 1, j);
    return leaf;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
