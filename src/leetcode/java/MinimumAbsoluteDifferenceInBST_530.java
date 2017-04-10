package leetcode.java;

public class MinimumAbsoluteDifferenceInBST_530 {
  private TreeNode prev = new TreeNode(Integer.MAX_VALUE);

  public int getMinimumDifference(TreeNode root) {
    return getMin(root, Integer.MAX_VALUE);
  }

  private int getMin(TreeNode node, int preMin) {
    if (node == null) return Math.min(preMin, Integer.MAX_VALUE);
    int min = getMin(node.left, preMin);
    min = Math.min(min, Math.abs(node.val - prev.val));
    prev = node;
    return Math.min(min, getMin(node.right, min));
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
