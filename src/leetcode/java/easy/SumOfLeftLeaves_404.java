package leetcode.java.easy;

public class SumOfLeftLeaves_404 {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null || root.left == null && root.right == null) return 0;
    return dfs(root.left, true) + dfs(root.right, false);
  }

  private int dfs(TreeNode node, boolean left) {
    if (node == null) return 0;
    if (node.left == null && node.right == null && left) {
      return node.val;
    }
    return dfs(node.left, true) + dfs(node.right, false);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
