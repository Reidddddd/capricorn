package leetcode.java;

public class BalancedBinaryTree_110 {
  public boolean isBalanced(TreeNode root) {
    return dfs(root) != -1;
  }

  private static int dfs(TreeNode node) {
    if (node == null) return 0;
    int left = dfs(node.left);
    int right = dfs(node.right);
    if (Math.abs(left - right) > 1 || left == -1 || right == -1) return -1;
    return Math.max(left, right) + 1;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
