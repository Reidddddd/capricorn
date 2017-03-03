package leetcode.java;

public class KthSmallestElementInABST_230 {
  private int cnt = 0;
  private int val = 0;
  private int tar;

  public int kthSmallest(TreeNode root, int k) {
    tar = k;
    preOrder(root);
    return val;
  }

  private void preOrder(TreeNode root) {
    if (root == null) return;

    preOrder(root.left);
    cnt++;
    if (cnt == tar) val = root.val;
    preOrder(root.right);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
