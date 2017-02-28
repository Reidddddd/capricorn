package leetcode.java;

public class ValidateBinarySearchTree_98 {
  public boolean isValidBST(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) return true;
    long l = Long.MIN_VALUE;
    int v = root.val;
    long r = Long.MAX_VALUE;
    return validSubTree(root.left, l, v) && validSubTree(root.right, v, r);
  }

  private boolean validSubTree(TreeNode node, long l, long r) {
    if (node == null) return true;
    if (l >= node.val || node.val >= r) return false;
    if (node.left == null && node.right == null) return true;
    return validSubTree(node.left, l, node.val) && validSubTree(node.right, node.val, r);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
