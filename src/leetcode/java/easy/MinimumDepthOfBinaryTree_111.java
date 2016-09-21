package leetcode.java.easy;

public class MinimumDepthOfBinaryTree_111 {
  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    int l = minDepth(root.left), r = minDepth(root.right);
    return 1 + (Math.min(l, r) > 0 ? Math.min(l, r) : Math.max(l, r));
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}