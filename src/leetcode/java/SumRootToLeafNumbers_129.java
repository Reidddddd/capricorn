package leetcode.java;

public class SumRootToLeafNumbers_129 {
  private int sum;

  public int sumNumbers(TreeNode root) {
    if (root == null) return 0;
    
    if (root.left == null && root.right == null) return root.val;
    dfs(root.left, root.val * 10);
    dfs(root.right, root.val * 10);
    return sum;
  }

  private void dfs(TreeNode node, int subSum) {
    if (node == null) return;
    subSum += node.val;
    if (node.left == null && node.right == null) {
      sum += subSum;
      return;
    }
    dfs(node.left, subSum * 10);
    dfs(node.right, subSum * 10);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
