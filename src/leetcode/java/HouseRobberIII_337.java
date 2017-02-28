package leetcode.java;

public class HouseRobberIII_337 {
  public int rob(TreeNode root) {
    int res[] = robSubTree(root);
    return Math.max(res[0], res[1]);
  }

  private int[] robSubTree(TreeNode node) {
    if (node == null) return new int[2];
    int[] left = robSubTree(node.left);
    int[] right = robSubTree(node.right);
    int[] res = new int[2];
    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    res[1] = node.val + left[0] + right[0];
    return res;
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
