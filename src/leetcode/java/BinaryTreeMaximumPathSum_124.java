package leetcode.java.hard;

public class BinaryTreeMaximumPathSum_124 {
  private int max;

  public int maxPathSum(TreeNode root) {
    max = Integer.MIN_VALUE;
    caculateMax(root);
    return max;
  }

  private int caculateMax(TreeNode node) {
    if (node == null) return 0;

    int lMax = Math.max(0, caculateMax(node.left));
    int rMax = Math.max(0, caculateMax(node.right));
    max = Math.max(max, lMax + rMax + node.val);
    return Math.max(lMax, rMax) + node.val;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
