package leetcode.java;

public class FlattenBinaryTreeToLinkedList_114 {
  public void flatten(TreeNode root) {
    if (root == null) return;
    if (root.left == null && root.right == null) return;

    flatten(root.right);
    flatten(root.left);
    if (root.left != null && root.right != null) {
      TreeNode pre = root.left;
      TreeNode cur = pre.right;
      while (cur != null) {
        pre = cur;
        cur = pre.right;
      }
      pre.right = root.right;
      root.right = root.left;
      root.left = null;
    }
    if (root.left != null && root.right == null) {
      root.right = root.left;
      root.left = null;
    }
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
